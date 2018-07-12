package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.investor.domain.Investor;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxLoanLent;

public class TxLoanLentMapper {

	public final static TxLoanLent map(Application source ) {
		TxLoanLent dest = new TxLoanLent();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".loanLent");
		dest.setApplication(LedgerConstant.ASSET_NS+".Applications#"+source.getId());
		return dest;
	}
}
