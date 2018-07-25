package com.whiz.quickloan.ledger.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.domain.Customer;
import com.whiz.quickloan.ledger.domain.Investor;

@Service
public class LedgerInvestorServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerInvestorServices.class);

	@Autowired
	private RestTemplate restTemplate;
	
	public String getInvestor() {
		String investor = "";
		try {
			//RestTemplate restTemplate = new RestTemplate();
			investor = restTemplate.getForObject(LedgerConstant.API_URL + "Investor", String.class);
			log.info(investor.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return investor;
	}
	
	public String saveInvestor(Investor investor) {
		ResponseEntity<Investor> responseInvestor  = null;
		try {
			log.info(investor.toString());
			responseInvestor = restTemplate.postForEntity(LedgerConstant.API_URL + "Investor",investor, Investor.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseInvestor.getBody().toString();
	}

	public void deleteInvestor(Integer investorId) {
		
		String url = LedgerConstant.API_URL + "investor/" + investorId;
		try {
			//RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(url);
			log.info("Ledger delete called!!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void updateInvestor(Investor investor) {

		String url = LedgerConstant.API_URL + "investor/" + investor.getId();
		try {
			//RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(url, investor);
			log.info("Ledger investor update called!!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
