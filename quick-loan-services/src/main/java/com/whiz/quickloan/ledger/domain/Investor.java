package com.whiz.quickloan.ledger.domain;

import lombok.Data;

@Data
public class Investor {
	
	public String $class;
	private String investorId;
	private String companyName;
	private String emailId;
	private int contact;
	private int[] applicationRequests;
	private int[] applicationsAssigned;
	private int totalLoanLent;
	
}
