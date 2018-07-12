package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxLoanRepaid;

public class TxLoanRepaidMapper {

	public final static TxLoanRepaid map(Application source) {
		
		TxLoanRepaid dest = new TxLoanRepaid();
		
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".loanRepaid");
		dest.setApplication(LedgerConstant.ASSET_NS + ".Applications#" +source.getId());
		
		return dest;
	}
}
