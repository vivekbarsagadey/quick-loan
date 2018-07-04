package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.ledger.LedgerConstant;

public final class CustomerMapper {
	
	public final static com.whiz.quickloan.ledger.domain.Customer map(Customer source ) {
		com.whiz.quickloan.ledger.domain.Customer dest = new com.whiz.quickloan.ledger.domain.Customer();
		dest.set$class(LedgerConstant.PARTICIPANT_NS + ".Customer");
		dest.setId(Integer.toString(source.getId()));
		dest.setStatus("ACTIVE");
		return dest;
	}
	
	public final static Customer map(com.whiz.quickloan.ledger.domain.Customer source ) {
		Customer dest = new Customer();
		return dest;
	}
}
