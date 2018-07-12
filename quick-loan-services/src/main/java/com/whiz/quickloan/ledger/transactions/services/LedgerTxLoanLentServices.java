package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxLoanLent;

@Service
public class LedgerTxLoanLentServices {

	private static final Logger log = LoggerFactory.getLogger(LedgerTxLoanLentServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String loanLent(TxLoanLent loanLent) {
		ResponseEntity<TxLoanLent> responseLoanLent  = null;
		
		try {
			log.info(loanLent.toString());
			responseLoanLent =  restTemplate.postForEntity(LedgerConstant.API_URL + "loanLent",loanLent, TxLoanLent.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseLoanLent.getBody().toString();
	}
}
