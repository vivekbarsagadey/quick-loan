package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxRejectApplication extends BaseDomain {

	public String application;
	public String remarks;
	
	public TxRejectApplication() {
		super();
	}

	/**
	 * @param investor
	 */
	public TxRejectApplication(String $class) {
		super();
		this.$class = $class;
	}
}
