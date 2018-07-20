package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxRequestInvestor;

public class TxRequestInvestorMapper {

	public final static TxRequestInvestor map(Application source ) {
		TxRequestInvestor dest = new TxRequestInvestor();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".requestInvestor");
		dest.setApplication(LedgerConstant.ASSET_NS+".Applications#"+source.getId());
		dest.setInvestor(LedgerConstant.PARTICIPANT_NS+".Investor#"+source.getInvestorId());
		return dest;
	}
}
