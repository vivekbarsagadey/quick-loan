package com.whiz.quickloan.ledger.domain;

import java.util.Arrays;

import lombok.Data;

@Data
public class Customer extends BaseDomain {
	
	private String customerId;
	private int[] allApplications = new int[] {};
	private String lender;
	

	@Override
	public String toString() {
		return "{\"$class\":\"" + $class + "\", \"customerId\" : \"" + customerId + "\", \"allApplications\":"
				+ Arrays.toString(allApplications) + ", \"lender\" :\"" + lender + "\"}";
	}
	
}
