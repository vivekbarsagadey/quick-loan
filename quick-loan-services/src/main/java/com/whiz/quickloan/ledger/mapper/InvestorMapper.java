package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.investor.domain.Investor;

public final class InvestorMapper {
	
	public final static com.whiz.quickloan.ledger.domain.Investor map(Investor source ) {
		com.whiz.quickloan.ledger.domain.Investor dest = new com.whiz.quickloan.ledger.domain.Investor();
		dest.$class = "org.speedloan.core.Investor";
		dest.setInvestorId(Integer.toString(source.getId()) );
		dest.setCompanyName(source.getCompanyName());
		dest.setEmailId(source.getContactDetails().getCompanyEmailId());
		dest.setContact(Integer.parseInt(source.getContactDetails().getCellPhone1()));
		int[] appReqList = new int[1];
		appReqList[0] = 0;
		dest.setApplicationRequests(appReqList);
		int[] appAssignedList = new int[1];
		appAssignedList[0]=0;
		dest.setApplicationsAssigned(appAssignedList);
		dest.setTotalLoanLent(0);
		
		return dest;
	}
	
	public final static Investor map(com.whiz.quickloan.ledger.domain.Investor source ) {
		Investor dest = new Investor();
		return dest;
	}

}
