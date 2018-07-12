package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.ledger.mapper.TxRequestInvestorMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxRequestInvestorServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
public class TxRequestInvestorController {

	@Autowired
	LedgerTxRequestInvestorServices ledgerTxRequestInvestorServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "request Investor")
	@RequestMapping(value = "/application/request/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity requestInvestor(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(consumer -> {
			ledgerTxRequestInvestorServices.requestInvestor(TxRequestInvestorMapper.map(consumer));
			
		});
		
		
		return new ResponseEntity("Investor Requested", HttpStatus.OK);
	}
}
