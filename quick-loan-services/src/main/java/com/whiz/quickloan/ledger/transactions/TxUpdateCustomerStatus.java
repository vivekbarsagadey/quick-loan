package com.whiz.quickloan.ledger.transactions;

import lombok.Data;

@Data
public class TxUpdateCustomerStatus extends BaseDomain {

	private String customer;
	private String status;

	public TxUpdateCustomerStatus() {
		super();
	}

	/**
	 * @param customer
	 */
	public TxUpdateCustomerStatus(String $class) {
		super();
		this.$class = $class;
	}

}
