package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.investor.domain.InvestorStatus;
import com.whiz.quickloan.investor.services.InvestorRepository;
import com.whiz.quickloan.ledger.mapper.TxUpdateInvestorStatusMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxUpdateInvestorStatusServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
@CrossOrigin
public class TxUpdateInvestorStatusController {

	@Autowired
	private LedgerTxUpdateInvestorStatusServices ledgerTxUpdateInvestorStatusServices;
	
	@Autowired
	private InvestorRepository investorRepository;
	
	@ApiOperation(value = "update investor")
	@RequestMapping(value = "/investor/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity block(@PathVariable Integer id, @PathVariable InvestorStatus status) {
	investorRepository.findById(id).ifPresent(investor -> {
			investor.setStatus(status);
			investor = investorRepository.save(investor);
			ledgerTxUpdateInvestorStatusServices.updateInvestorStatus(TxUpdateInvestorStatusMapper.map(investor));
			
		});
		return new ResponseEntity("Investor status changed successfully", HttpStatus.OK);
	}
	
}
