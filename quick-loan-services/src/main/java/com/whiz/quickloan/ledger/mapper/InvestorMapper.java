package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.investor.domain.Investor;
import com.whiz.quickloan.ledger.LedgerConstant;

public final class InvestorMapper {
	
	public final static com.whiz.quickloan.ledger.domain.Investor map(Investor source ) {
		com.whiz.quickloan.ledger.domain.Investor dest = new com.whiz.quickloan.ledger.domain.Investor();
		dest.set$class( LedgerConstant.PARTICIPANT_NS + ".Investor");
		dest.setInvestorId(Integer.toString(source.getId()) );
		dest.setApplicationRequests("resource:org.quickloan.assets.Applications#0");
		dest.setApplicationAssigned("resource:org.quickloan.assets.Applications#0");
		dest.setTotalLoanLent(0);
		
		return dest;
	}
	
	public final static Investor map(com.whiz.quickloan.ledger.domain.Investor source ) {
		Investor dest = new Investor();
		return dest;
	}
}