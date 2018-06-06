package com.whiz.quickloan.investor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.customer.domain.BestTimeToCall;
import com.whiz.quickloan.investor.domain.Investor;
import com.whiz.quickloan.investor.domain.LoanRange;
import com.whiz.quickloan.investor.services.InvestorRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;

@RestController
@RequestMapping("/api/investor")
public class InvestorController {

	@Autowired
	private InvestorRepository investorRepository;

	@ApiOperation(value = "View a list of available Investors", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbinvestorIdden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Investor> list(Model model) {
		Iterable<Investor> InvestorList = investorRepository.findAll();
		return InvestorList;
	}

	@ApiOperation(value = "Add an Investor")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity save(@RequestBody Investor investor) {
		investor.setLoanRange(LoanRange.UPTO_1000);
		investor.getAddressDetails().setInvestor(investor);
		investor.getContactDetails().setInvestor(investor);
		investor.getPaymentDetails().setInvestor(investor);
		investor.getBankDetails().setInvestor(investor);
		// investor.setContact(contact);
		investorRepository.save(investor);
		return new ResponseEntity("Investor details saved successfully!", HttpStatus.OK);
	}

	@ApiOperation(value = "Update an Investor")
	@RequestMapping(value = "/{investorId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity update(@PathVariable Integer investorId, @RequestBody Investor investor) {

		Investor storedInvestor = investorRepository.findById(investorId).orElse(null);
		if (storedInvestor != null) {
			investorRepository.save(storedInvestor);
			return new ResponseEntity("Investor updated successfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Investor update failed!", HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Delete an Investor")
	@RequestMapping(value = "/{investorId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer investorId) {
		investorRepository.deleteById(investorId);
		return new ResponseEntity("Investor deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Search an Investor with an ID", response = Investor.class)
	@RequestMapping(value = "/{investorId}", method = RequestMethod.GET, produces = "application/json")
	public Investor search(@PathVariable Integer investorId, Model model) {
		return investorRepository.findById(investorId).orElse(new Investor());
	}
}