package com.whiz.quickloan.ledger.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Investor extends BaseDomain{
	
	private String investorId;
	private String applicationRequests;
	private String applicationAssigned;
	private int totalLoanLent;
	
	
	@Override
	public String toString() {
		return "{\"$class\":\"" + $class + "\", \"investorId\" : \"" + investorId + "\", \"applicationRequests\": \"resource:org.quickloan.assets.Applications#"
				+ applicationRequests + "\",  \"applicationAssigned\": \"resource:org.quickloan.assets.Applications#"
						+ applicationAssigned + "\", \"totalLoanLent\" :" + totalLoanLent + "}";
	}
}
