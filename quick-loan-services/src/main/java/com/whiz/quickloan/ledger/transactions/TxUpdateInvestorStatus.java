package com.whiz.quickloan.ledger.transactions;

import lombok.Data;

@Data
public class TxUpdateInvestorStatus extends BaseDomain {

	private String investor;
	private String status;
	
	public TxUpdateInvestorStatus() {
		super();
	}
	
	public TxUpdateInvestorStatus(String $class) {
		super();
		this.$class = $class;
	}
}
