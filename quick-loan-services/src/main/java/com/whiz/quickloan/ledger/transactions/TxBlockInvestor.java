package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxBlockInvestor extends BaseDomain{
	
	private String investor;
	
	public TxBlockInvestor() {
		super();
	}

	/**
	 * @param investor
	 */
	public TxBlockInvestor(String $class) {
		super();
		this.$class = $class;
	}
}