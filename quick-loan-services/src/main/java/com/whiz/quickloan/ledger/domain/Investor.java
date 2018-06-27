package com.whiz.quickloan.ledger.domain;

import java.util.Arrays;

import lombok.Data;

@Data
public class Investor {
	
	public String $class;
	private String investorId;
	private int applicationRequests;
	private int applicationAssigned;
	private int totalLoanLent;
	
	@Override
	public String toString() {
		return "{\"$class\":\"" + $class + "\", \"investorId\" : \"" + investorId + "\", \"applicationRequests\": \"resource:org.speedloan.core.Applications#"
				+ applicationRequests + "\",  \"applicationAssigned\": \"resource:org.speedloan.core.Applications#"
						+ applicationAssigned + "\", \"totalLoanLent\" :" + totalLoanLent + "}";
	}
}
