package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.domain.Application;
import com.whiz.quickloan.ledger.transactions.TxApplication;

@Service
public class LedgerTxApplicationServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerTxApplicationServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public String createApplication(Application application) {
		ResponseEntity<TxApplication> responseCustomer  = null;
		TxApplication txApplication = new TxApplication("org.quickloan.transactions.createApplication");
		txApplication.setApplication(application);
		try {
			log.info(txApplication.toString());
			responseCustomer  =  restTemplate.postForEntity(LedgerConstant.API_URL + "createApplication",txApplication , TxApplication.class);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return responseCustomer.getBody().toString();
	}



}