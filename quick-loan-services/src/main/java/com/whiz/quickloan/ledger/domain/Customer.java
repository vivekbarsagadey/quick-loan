package com.whiz.quickloan.ledger.domain;

import java.util.Arrays;

import lombok.Data;

@Data
public class Customer {
	
	private String $class;
	private String customerId;
	private int[] allApplications = new int[] {};
	private String lender;
	
	public String get$class() {
		return this.$class;
	}
	
	public void set$class(String name) {
		this.$class = name;
	}

	@Override
	public String toString() {
		return "{\"$class\":\"" + $class + "\", \"customerId\" : \"" + customerId + "\", \"allApplications\":"
				+ Arrays.toString(allApplications) + ", \"lender\" :\"" + lender + "\"}";
	}
	
}
