package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.investor.services.InvestorRepository;
import com.whiz.quickloan.ledger.mapper.TxBlockInvestorMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxBlockInvestorServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
public class TxBlockinvestorController {
	
	@Autowired
	LedgerTxBlockInvestorServices ledgerTxBlockInvestorServices;
	
	@Autowired
	private InvestorRepository investorRepository;
	
	@ApiOperation(value = "block test")
	@RequestMapping(value = "/investor/block/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity block(@PathVariable Integer id) {
		investorRepository.findById(id).ifPresent(consumer -> {
			ledgerTxBlockInvestorServices.blockInvestor(TxBlockInvestorMapper.map(consumer));
			
		});
		
		/*Investor c = new Investor(); 
		c.setId(1);
		
		ledgerTxBlockInvestorServices.blockInvestor(TxBlockInvestorMapper.map(c));*/
		
		return new ResponseEntity("Investor blocked successfully", HttpStatus.OK);
	}
}