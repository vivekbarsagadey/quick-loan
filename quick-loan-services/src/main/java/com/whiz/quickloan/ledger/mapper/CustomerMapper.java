package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.customer.domain.Customer;

public final class CustomerMapper {
	
	public final static com.whiz.quickloan.ledger.domain.Customer map(Customer source ) {
		com.whiz.quickloan.ledger.domain.Customer dest = new com.whiz.quickloan.ledger.domain.Customer();
		dest.$class = "org.speedloan.core.Customer";
		dest.setCustomerId(Integer.toString(source.getId()) );
		dest.setFirstName(source.getFirstName());
		dest.setLastName(source.getLastName());
		dest.setEmailId(source.getContactDetails().getEmailId());
		dest.setContact(Integer.parseInt(source.getContactDetails().getCellPhone1()));
		dest.setLoanAmount(source.getLoanDetails().getLoanAmount());
		dest.setLoanStatus("In Process");
		dest.setLender("resource:org.speedloan.core.Investor"+"#201");
		return dest;
	}
	
	public final static Customer map(com.whiz.quickloan.ledger.domain.Customer source ) {
		Customer dest = new Customer();
		return dest;
	}

}
