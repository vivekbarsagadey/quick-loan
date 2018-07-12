package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxLoanRepaid extends BaseDomain {

	
	private String application;
	
	public TxLoanRepaid() {
		super();
	}
	
	public TxLoanRepaid(String $class) {
		super();
		this.$class = $class;
	}

}
