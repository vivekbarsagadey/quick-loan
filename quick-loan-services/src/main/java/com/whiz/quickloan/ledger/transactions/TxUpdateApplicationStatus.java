package com.whiz.quickloan.ledger.transactions;

import lombok.Data;

@Data
public class TxUpdateApplicationStatus extends BaseDomain {

	private String application;
	private String status;
	private String remarks;
	
	
	public TxUpdateApplicationStatus(String $class) {
		super();
		this.$class = $class;
	}


	public TxUpdateApplicationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
}
