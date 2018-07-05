package com.whiz.quickloan.ledger.transactions;

import com.whiz.quickloan.ledger.domain.Investor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TxBlockInvestor extends BaseDomain{
	
	private Investor investor;
	
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

	/*@Override
	public String toString() {
		return "";
	}*/
}