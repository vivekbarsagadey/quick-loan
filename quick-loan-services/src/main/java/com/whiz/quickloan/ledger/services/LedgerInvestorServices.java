package com.whiz.quickloan.ledger.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.investor.domain.Investor;
import com.whiz.quickloan.ledger.LedgerConstant;

@Service
public class LedgerInvestorServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerInvestorServices.class);

	public String getInvestor() {
		String investor = "";
		try {
			RestTemplate restTemplate = new RestTemplate();
			investor = restTemplate.getForObject(LedgerConstant.API_URL + "Investor", String.class);
			log.info(investor.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return investor;
	}
	
	public Investor saveInvestor(com.whiz.quickloan.ledger.domain.Investor investor) {
		ResponseEntity<Investor> response  = null;
		try {
			log.info(investor.toString());
			RestTemplate restTemplate = new RestTemplate();
			response  = restTemplate.postForEntity(LedgerConstant.API_URL + "Investor",investor, Investor.class);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return response.getBody();
	}
}
