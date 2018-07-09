package com.whiz.quickloan.applications.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.mapper.ApplicationMapper;
import com.whiz.quickloan.ledger.services.LedgerApplicationServices;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxApplicationServices;

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
	private LedgerApplicationServices ledgerApplicationServices;
	
	@Autowired
	private LedgerTxApplicationServices ledgerTxApplicationServices;
	
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
	public Iterable<Application> list(Model model) {
		Iterable<Application> ApplicationsList = applicationsRepository.findAll();
		return ApplicationsList;
	}

	@ApiOperation(value = "Create an Application")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveApplication(@RequestBody Application application) {
		application.setApplicationDate(LocalDate.now());
		application.setCustomerId(0);
		application.setRemarks("");
		
		applicationsRepository.save(application);
		
		// update ledger data
		String response = ledgerApplicationServices.saveApplication(ApplicationMapper.map(application));
				
		//return new ResponseEntity("Application saved successfully", HttpStatus.OK);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Update an Application")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateApplication(@PathVariable Integer id, @RequestBody Application application) {

		Application storedApplications = applicationsRepository.findById(id).orElse(null);
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
	
	@ApiOperation(value = "Search an Application with ID", response = Application.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Application showApplications(@PathVariable Integer id, Model model) {
		return applicationsRepository.findById(id).orElse(new Application());
	}
	
	//Add application to ledger
	@ApiOperation(value = "LedgerTxApplicationServices test", response = Application.class)
	@RequestMapping(value = "/LedgerTxApplicationServices/{id}", method = RequestMethod.GET, produces = "application/json")
	public String testLedgerTxApplicationServices(@PathVariable Integer id) {
		return ledgerTxApplicationServices.createApplication(ApplicationMapper.map(new Application(id)));
	}
}