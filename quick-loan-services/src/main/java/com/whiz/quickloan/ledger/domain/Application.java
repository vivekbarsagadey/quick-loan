package com.whiz.quickloan.ledger.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Application extends BaseDomain {

	//private String id;
	private String customer;
	private String investor;
	private String applicationDate;
	private Integer loanAmount;
	private String status;
	private String state;
	private String remarks;
}
