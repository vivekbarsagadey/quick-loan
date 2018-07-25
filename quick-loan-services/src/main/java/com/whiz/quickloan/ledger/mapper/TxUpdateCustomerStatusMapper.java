package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateCustomerStatus;

public class TxUpdateCustomerStatusMapper {

	public final static TxUpdateCustomerStatus map(Customer source ) {
		TxUpdateCustomerStatus dest = new TxUpdateCustomerStatus();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".updateCustomerStatus");
		dest.setCustomer(LedgerConstant.PARTICIPANT_NS+".Customer#"+source.getId());
		dest.setStatus(source.getStatus().toString());
		return dest;
	}
}
