package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxBlockCustomer;

@Service
public class LedgerTxBlockCustomerServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerTxBlockCustomerServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String blockCustomer(TxBlockCustomer blockCustomer) {
		ResponseEntity<TxBlockCustomer> responseCustomer  = null;
		try {
			log.info(blockCustomer.toString());
			responseCustomer  =  restTemplate.postForEntity(LedgerConstant.API_URL + "blockCustomer",blockCustomer, TxBlockCustomer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseCustomer.getBody().toString();
	}
}