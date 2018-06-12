package com.whiz.quickloan.ledger.domain;

import lombok.Data;

@Data
public class Customer {
	
	public String $class;
	private String customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private int contact;
	private int loanAmount;
	private String loanStatus;
	private String lender;
	
}
