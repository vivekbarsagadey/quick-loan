package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateScore;

@Service
public class LedgerTxUpdateScoreServices {

private static final Logger log = LoggerFactory.getLogger(LedgerTxUpdateScoreServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String updateScore(TxUpdateScore updateScore) {
		ResponseEntity<TxUpdateScore> response  = null;
		
		try {
			log.info(updateScore.toString());
			response =  restTemplate.postForEntity(LedgerConstant.API_URL + "updateScore", updateScore, TxUpdateScore.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getBody().toString();
	}
}
