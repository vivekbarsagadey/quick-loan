package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxApproveApplication;

@Service
public class LedgerTxApproveApplicationServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerTxApproveApplicationServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String approveApplication(TxApproveApplication approveApplication) {
		ResponseEntity<TxApproveApplication> responseApplication  = null;
		/*TxBlockInvestor txBlockInvestor = new TxBlockInvestor("org.quickloan.transactions.blockInvestor");
		txBlockInvestor.setInvestor(investor);*/
		try {
			log.info(approveApplication.toString());
			responseApplication =  restTemplate.postForEntity(LedgerConstant.API_URL + "approveApplication",approveApplication, TxApproveApplication.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseApplication.getBody().toString();
	}
}
