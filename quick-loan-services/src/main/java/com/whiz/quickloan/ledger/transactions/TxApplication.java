package com.whiz.quickloan.ledger.transactions;

import com.whiz.quickloan.ledger.domain.Application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TxApplication extends BaseDomain{
	
	private Application application;
	
	public TxApplication() {
		super();
	}

	/**
	 * @param application
	 */
	public TxApplication(String $class) {
		super();
		this.$class = $class;
	}

	@Override
	public String toString() {
		return "{\"application\":" + application.toString() + ", \"$class\":\"" + $class + "\"}";
	}
	
}
