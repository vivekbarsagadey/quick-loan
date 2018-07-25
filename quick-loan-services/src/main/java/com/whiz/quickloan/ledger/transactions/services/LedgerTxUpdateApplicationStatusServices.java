package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateApplicationStatus;

@Service
public class LedgerTxUpdateApplicationStatusServices {

	private static final Logger log = LoggerFactory.getLogger(LedgerTxRequestInvestorServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public String updateApplicationStatus(TxUpdateApplicationStatus updateApplicationStatus) {

		ResponseEntity<TxUpdateApplicationStatus> responseApplication  = null;
		
		try {
			log.info(updateApplicationStatus.toString());
			responseApplication =  restTemplate.postForEntity(LedgerConstant.API_URL + "updateApplicationStatus", updateApplicationStatus, TxUpdateApplicationStatus.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseApplication.getBody().toString();
	}

}
