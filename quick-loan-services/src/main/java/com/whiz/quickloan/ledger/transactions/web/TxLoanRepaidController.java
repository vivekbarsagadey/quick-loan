package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.ledger.mapper.TxLoanRepaidMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxLoanRepaidServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/ledger")
public class TxLoanRepaidController {

	@Autowired
	LedgerTxLoanRepaidServices ledgerTxLoanPrepaidServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "loan prepaid")
	@RequestMapping(value = "/application/loanprepaid/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity approve(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(application -> {
			ledgerTxLoanPrepaidServices.loanRepaid(TxLoanRepaidMapper.map(application));
			
		});
		
		
		return new ResponseEntity("Loan Repaid", HttpStatus.OK);
	}
}
