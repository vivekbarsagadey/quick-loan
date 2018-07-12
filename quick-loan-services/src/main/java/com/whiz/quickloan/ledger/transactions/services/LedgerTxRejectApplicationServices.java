package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxRejectApplication;

@Service
public class LedgerTxRejectApplicationServices {

private static final Logger log = LoggerFactory.getLogger(LedgerTxRejectApplicationServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String rejectApplication(TxRejectApplication rejectApplication) {
		ResponseEntity<TxRejectApplication> responseApplication  = null;
		
		try {
			log.info(rejectApplication.toString());
			responseApplication =  restTemplate.postForEntity(LedgerConstant.API_URL + "rejectApplication", rejectApplication, TxRejectApplication.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseApplication.getBody().toString();
	}
}
