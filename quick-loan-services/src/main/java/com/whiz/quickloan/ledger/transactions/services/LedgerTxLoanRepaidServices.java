package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxLoanRepaid;

@Service
public class LedgerTxLoanRepaidServices {

	public static final Logger log = LoggerFactory.getLogger(LedgerTxLoanRepaidServices.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public String loanRepaid(TxLoanRepaid loanRepaid) {
		
		ResponseEntity<TxLoanRepaid> responseLoanRepaid = null;
		
		try {
			log.info(loanRepaid.toString());
			responseLoanRepaid = restTemplate.postForEntity(LedgerConstant.API_URL + "loanRepaid", loanRepaid, TxLoanRepaid.class );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseLoanRepaid.getBody().toString();
	}
}
