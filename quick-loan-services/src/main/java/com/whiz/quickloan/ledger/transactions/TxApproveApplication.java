package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxApproveApplication extends BaseDomain{
	
	private String application;
	
	public TxApproveApplication() {
		super();
	}

	/**
	 * @param investor
	 */
	public TxApproveApplication(String $class) {
		super();
		this.$class = $class;
	}
}
