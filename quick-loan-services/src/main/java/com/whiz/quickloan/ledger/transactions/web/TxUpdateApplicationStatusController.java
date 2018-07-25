package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.applications.domain.ApplicationState;
import com.whiz.quickloan.applications.domain.ApplicationStatus;
import com.whiz.quickloan.ledger.mapper.TxUpdateApplicationStatusMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxUpdateApplicationStatusServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
@CrossOrigin
public class TxUpdateApplicationStatusController {


	@Autowired
	LedgerTxUpdateApplicationStatusServices ledgerTxUpdateApplicationStatusServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "update application status")
	@RequestMapping(value = "/application/updateStatus/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity reject(@PathVariable Integer id, @PathVariable ApplicationStatus status) {
		applicationsRepository.findById(id).ifPresent(application -> {
			
			// update in DB
			application.setStatus(status);
//			application.setState(ApplicationState.FAIL);
			application = applicationsRepository.save(application);
			
			// update in ledger
			ledgerTxUpdateApplicationStatusServices.updateApplicationStatus(TxUpdateApplicationStatusMapper.map(application));
			
		});
		return new ResponseEntity("Application Rejected", HttpStatus.OK);
	}
	
	
/*	@ApiOperation(value = "loan prepaid")
	@RequestMapping(value = "/application/loanprepaid/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity loanRepaid(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(application -> {
			
			// update in DB
			application.setStatus(ApplicationStatus.LOAN_REPAID);
			application = applicationsRepository.save(application);

			// update in ledger
			ledgerTxUpdateApplicationStatusServices.updateApplicationStatus(TxUpdateApplicationStatusMapper.map(application));
		});
		return new ResponseEntity("Loan Repaid", HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "approve application")
	@RequestMapping(value = "/application/approve/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity approve(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(application -> {
			
			// update in DB
			application.setState(ApplicationState.APPROVED);
			application.setStatus(ApplicationStatus.APPROVED);
			application = applicationsRepository.save(application);
			
			// update in ledger
			ledgerTxUpdateApplicationStatusServices.updateApplicationStatus(TxUpdateApplicationStatusMapper.map(application));
			
		});
		
		return new ResponseEntity("Application Approved successfully", HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "loan lent")
	@RequestMapping(value = "/application/loanlent/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity loanLent(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(application -> {
			
			// update in DB
			application.setStatus(ApplicationStatus.LOAN_LENT);
			application = applicationsRepository.save(application);

			// update in ledger
			ledgerTxUpdateApplicationStatusServices.updateApplicationStatus(TxUpdateApplicationStatusMapper.map(application));
		});
		
		
		return new ResponseEntity("Loan Lent successful", HttpStatus.OK);
	}*/
	
}
