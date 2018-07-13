package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.customer.services.CustomerRepository;
import com.whiz.quickloan.ledger.mapper.TxUpdateScoreMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxUpdateScoreServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
public class TxUpdateScoreController {

	@Autowired
	LedgerTxUpdateScoreServices ledgerTxUpdateScoreServices;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@ApiOperation(value = "update Score")
	@RequestMapping(value = "/customer/updateScore/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity updateScore(@PathVariable Integer id) {
		customerRepository.findById(id).ifPresent(consumer -> {
			ledgerTxUpdateScoreServices.updateScore(TxUpdateScoreMapper.map(consumer));
			
		});
		
		
		return new ResponseEntity("Score Updated", HttpStatus.OK);
	}
}
