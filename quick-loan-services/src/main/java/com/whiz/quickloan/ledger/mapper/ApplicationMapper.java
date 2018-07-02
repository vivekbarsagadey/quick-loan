package com.whiz.quickloan.ledger.mapper;

import java.util.Date;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;

public final class ApplicationMapper {
	
	public final static com.whiz.quickloan.ledger.domain.Application map(Application source ) {
		com.whiz.quickloan.ledger.domain.Application dest = new com.whiz.quickloan.ledger.domain.Application();
		dest.set$class(LedgerConstant.ASSET_NS + ".Applications");
		dest.setCustomer("resource:org.quickloan.participants.Customer#1");
		dest.setApplicationId(source.getId().toString());
		dest.setLoanAmount(100);
		dest.setApplicationStatus("In Process");
		dest.setRemarks("No remarks");
		dest.setApplicationDate("2018-07-02T16:20:23.940Z");
		
		return dest;
	}
	
}
