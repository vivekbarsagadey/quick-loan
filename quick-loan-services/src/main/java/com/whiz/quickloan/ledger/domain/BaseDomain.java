package com.whiz.quickloan.ledger.domain;

import lombok.Data;

@Data
abstract class BaseDomain {
	
	protected String $class;
	protected String id;
	
	public String get$class() {
		return this.$class;
	}
	
	public void set$class(String $class) {
		this.$class = $class;
	}

	
}
