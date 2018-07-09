package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.application.services.ApplicationsRepository;
import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.investor.services.InvestorRepository;
import com.whiz.quickloan.ledger.mapper.TxApproveApplicationMapper;
import com.whiz.quickloan.ledger.mapper.TxBlockInvestorMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxApproveApplicationServices;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxBlockInvestorServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
public class TxApproveApplicationController {
	
	@Autowired
	LedgerTxApproveApplicationServices ledgerTxApproveApplicationServices;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@ApiOperation(value = "approve application")
	@RequestMapping(value = "/application/approve/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity approve(@PathVariable Integer id) {
		applicationsRepository.findById(id).ifPresent(consumer -> {
			ledgerTxApproveApplicationServices.approveApplication(TxApproveApplicationMapper.map(consumer));
			
		});
		
		/*Application c = new Application();
		c.setId(1);
		
		ledgerTxApproveApplicationServices.approveApplication(TxApproveApplicationMapper.map(c));*/
		
		return new ResponseEntity("Application Approved successfully", HttpStatus.OK);
	}
}
