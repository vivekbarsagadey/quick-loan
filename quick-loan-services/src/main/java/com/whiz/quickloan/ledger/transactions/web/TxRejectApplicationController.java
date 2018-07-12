package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.ledger.mapper.TxRejectApplicationMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxRejectApplicationServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
public class TxRejectApplicationController {

	@Autowired
	LedgerTxRejectApplicationServices ledgerTxRejectApplicationServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "reject application")
	@RequestMapping(value = "/application/reject/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity reject(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(consumer -> {
			ledgerTxRejectApplicationServices.rejectApplication(TxRejectApplicationMapper.map(consumer));
			
		});
		
		
		return new ResponseEntity("Application Rejected", HttpStatus.OK);
	}
}
