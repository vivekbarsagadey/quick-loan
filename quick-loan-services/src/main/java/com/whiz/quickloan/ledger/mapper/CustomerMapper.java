package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.customer.domain.Customer;

public final class CustomerMapper {
	
	public final static com.whiz.quickloan.ledger.domain.Customer map(Customer source ) {
		com.whiz.quickloan.ledger.domain.Customer dest = new com.whiz.quickloan.ledger.domain.Customer();
		dest.set$class("org.speedloan.core.Customer"); 
		dest.setCustomerId(Integer.toString(source.getId()));
		/*int[] allApplications = new int[0];
		allApplications[0] = 0;
		dest.setAllApplications(allApplications);*/
		dest.setAllApplications(new int[] {});
		dest.setLender("resource:org.speedloan.core.Investor"+"#0");
		return dest;
	}
	
	public final static Customer map(com.whiz.quickloan.ledger.domain.Customer source ) {
		Customer dest = new Customer();
		return dest;
	}
}
