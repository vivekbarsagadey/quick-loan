package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.applications.domain.ApplicationState;
import com.whiz.quickloan.applications.domain.ApplicationStatus;
import com.whiz.quickloan.ledger.mapper.TxRequestInvestorMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxRequestInvestorServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
@CrossOrigin
public class TxRequestInvestorController {

	@Autowired
	LedgerTxRequestInvestorServices ledgerTxRequestInvestorServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "request Investor")
	@RequestMapping(value = "/application/request/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity requestInvestor(@PathVariable Integer id, @RequestParam Integer investorId) {
		applicationsRepository.findById(id).ifPresent(application -> {
			application.setInvestorId(investorId);
			application.setStatus(ApplicationStatus.REQUESTED);
			application.setState(ApplicationState.WAITING_FOR_APPROVAL);
			applicationsRepository.save(application);
			ledgerTxRequestInvestorServices.requestInvestor(application);
			
		});
		
		return new ResponseEntity("Investor Requested", HttpStatus.OK);
	}
}
