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
import com.whiz.quickloan.investor.services.InvestorRepository;
import com.whiz.quickloan.ledger.mapper.TxLoanLentMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxLoanLentServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/ledger")
@CrossOrigin
public class TxLoanLentController {

	@Autowired
	LedgerTxLoanLentServices ledgerTxLoanLentServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "loan lent")
	@RequestMapping(value = "/application/loanlent/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity approve(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(application -> {
			ledgerTxLoanLentServices.loanLent(TxLoanLentMapper.map(application));
			
		});
		
		
		return new ResponseEntity("Loan Lent successful", HttpStatus.OK);
	}
}
