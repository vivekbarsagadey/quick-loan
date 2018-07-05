package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxBlockCustomer;

public final class TxBlockCustomerMapper {
	
	public final static TxBlockCustomer map(Customer source ) {
		TxBlockCustomer dest = new TxBlockCustomer();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".blockCustomer");
		dest.setCustomer(LedgerConstant.PARTICIPANT_NS+".Customer#"+source.getId());
		return dest;
	}
	
	
}
