package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public final class TxLoanLent extends BaseDomain {

	private String application;
	
	public TxLoanLent() {
		super();
	}
	
	public TxLoanLent(String $class) {
		super();
		this.$class = $class;
	}
}
