package com.whiz.quickloan.ledger.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Investor extends BaseDomain{
	private double totalLoanLent;
	private String status;
	
}
