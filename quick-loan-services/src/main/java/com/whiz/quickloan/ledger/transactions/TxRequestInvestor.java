package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxRequestInvestor extends BaseDomain {

	public String application;
	public String investor;
	
	public TxRequestInvestor() {
		super();
	}

	/**
	 * @param investor
	 */
	public TxRequestInvestor(String $class) {
		super();
		this.$class = $class;
	}
}
