package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.mapper.TxRequestInvestorMapper;
import com.whiz.quickloan.ledger.transactions.TxRequestInvestor;

@Service
public class LedgerTxRequestInvestorServices {

private static final Logger log = LoggerFactory.getLogger(LedgerTxRequestInvestorServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public void requestInvestor(Application application) {
		this.requestInvestor(TxRequestInvestorMapper.map(application));
		
	}
	
	public String requestInvestor(TxRequestInvestor requestInvestor) {
		ResponseEntity<TxRequestInvestor> responseApplication  = null;
		
		try {
			log.info(requestInvestor.toString());
			responseApplication =  restTemplate.postForEntity(LedgerConstant.API_URL + "requestInvestor", requestInvestor, TxRequestInvestor.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseApplication.getBody().toString();
	}
}
