package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxBlockCustomer extends BaseDomain{
	
	private String customer;
	public TxBlockCustomer() {
		super();
	}

	/**
	 * @param customer
	 */
	public TxBlockCustomer(String $class) {
		super();
		this.$class = $class;
	}

	
}