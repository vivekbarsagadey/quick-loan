package com.whiz.quickloan.ledger.transactions.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateInvestorStatus;

@Service
public class LedgerTxUpdateInvestorStatusServices {

private static final Logger log = LoggerFactory.getLogger(LedgerTxUpdateInvestorStatusServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String updateInvestorStatus(TxUpdateInvestorStatus updateInvestorStatus) {
		ResponseEntity<TxUpdateInvestorStatus> responseInvestor = null;
		try {
			log.info(updateInvestorStatus.toString());
			responseInvestor  =  restTemplate.postForEntity(LedgerConstant.API_URL + "updateInvestorStatus", updateInvestorStatus, TxUpdateInvestorStatus.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInvestor.getBody().toString();
	}
}
