package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateCustomerStatus;

@Service
public class LedgerTxUpdateCustomerStatusServices {

	private static final Logger log = LoggerFactory.getLogger(LedgerTxUpdateCustomerStatusServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String updateCustomerStatus(TxUpdateCustomerStatus updateCustomerStatus) {
		ResponseEntity<TxUpdateCustomerStatus> responseCustomer  = null;
		try {
			log.info(updateCustomerStatus.toString());
			responseCustomer  =  restTemplate.postForEntity(LedgerConstant.API_URL + "updateCustomerStatus", updateCustomerStatus, TxUpdateCustomerStatus.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseCustomer.getBody().toString();
	}
}
