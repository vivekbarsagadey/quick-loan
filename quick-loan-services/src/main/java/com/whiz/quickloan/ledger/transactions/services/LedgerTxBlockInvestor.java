package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.domain.Investor;
import com.whiz.quickloan.ledger.transactions.TxBlockInvestor;

@Service
public class LedgerTxBlockInvestor {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerTxBlockInvestor.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String createApplication(Investor investor) {
		ResponseEntity<TxBlockInvestor> responseInvestor  = null;
		TxBlockInvestor txBlockInvestor = new TxBlockInvestor("org.quickloan.transactions.blockInvestor");
		txBlockInvestor.setInvestor(investor);
		try {
			log.info(txBlockInvestor.toString());
			responseInvestor  =  restTemplate.postForEntity(LedgerConstant.API_URL + "blockInvestor",txBlockInvestor, TxBlockInvestor.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInvestor.getBody().toString();
	}
}