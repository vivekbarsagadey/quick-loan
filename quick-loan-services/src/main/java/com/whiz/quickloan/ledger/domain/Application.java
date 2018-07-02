package com.whiz.quickloan.ledger.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Application extends BaseDomain{
	
	private String applicationId;
	private String customer;
	private String applicationDate;
	private Integer loanAmount;
	private String applicationStatus;
	private String remarks;
	@Override
	public String toString() {
		return "{\"applicationId\":\"" + applicationId + "\", \"customer\":\"" + customer + "\", \"applicationDate\":\""
				+ applicationDate + "\", \"loanAmount\":" + loanAmount + ", \"applicationStatus\":\"" + applicationStatus
				+ "\", \"remarks\":\"" + remarks + "\", \"$class\":\"" + $class + "\"}";
	}
	
	
	

}
