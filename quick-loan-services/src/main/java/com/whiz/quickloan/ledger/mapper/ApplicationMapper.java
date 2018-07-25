package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;

public final class ApplicationMapper {

	public final static com.whiz.quickloan.ledger.domain.Application map(Application source) {
		com.whiz.quickloan.ledger.domain.Application dest = new com.whiz.quickloan.ledger.domain.Application();
		dest.set$class(LedgerConstant.ASSET_NS + ".Applications");
		dest.setId(Integer.toString(source.getId()));
		dest.setCustomer("resource:org.whizit.pronto.participants.Customer#"+ source.getCustomerId());
		dest.setInvestor("resource:org.whizit.pronto.participants.Investor#"+ source.getInvestorId());
		dest.setApplicationDate("2018-07-04T10:06:34.591Z");
		dest.setLoanAmount(150);
		dest.setStatus("RECEIVED");
		dest.setState("RECEIVED_QLAP");
		dest.setRemarks("");

		return dest;
	}

	public final static Application map(com.whiz.quickloan.ledger.domain.Application source) {
		Application dest = new Application();
		return dest;
	}
}
