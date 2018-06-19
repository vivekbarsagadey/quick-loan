package com.whiz.quickloan.applications.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.applications.domain.Applications;
import com.whiz.quickloan.ledger.services.LedgerCustomerServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {

	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@Autowired
	private LedgerCustomerServices ledgerCustomerServices;
	
	@ApiOperation(value = "View a list of available Applications", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public Iterable<Applications> list(Model model) {
		Iterable<Applications> ApplicationsList = applicationsRepository.findAll();
		return ApplicationsList;
	}

	@ApiOperation(value = "Create an Application")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveApplication(@RequestBody Applications application) {
		applicationsRepository.save(application);
		return new ResponseEntity("Application saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update an Application")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateApplication(@PathVariable Integer id, @RequestBody Applications application) {

		Applications storedApplications = applicationsRepository.findById(id).orElse(null);
		if(storedApplications !=null) {
			applicationsRepository.save(storedApplications);
			return new ResponseEntity("Application updated successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity("Application update failed!", HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Delete an Application")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
		applicationsRepository.deleteById(id);
		return new ResponseEntity("Application deleted successfully!", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Search an Application with ID", response = Applications.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Applications showApplications(@PathVariable Integer id, Model model) {
		return applicationsRepository.findById(id).orElse(new Applications());
	}
	
	
	@ApiOperation(value = "LedgerCustomerServices test", response = Applications.class)
	@RequestMapping(value = "/LedgerCustomerServices/", method = RequestMethod.GET, produces = "application/json")
	public String testLedgerCustomerServices(Model model) {
		return ledgerCustomerServices.getCustomer();
	}
}