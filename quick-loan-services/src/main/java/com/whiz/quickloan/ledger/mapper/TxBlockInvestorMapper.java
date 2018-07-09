package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.investor.domain.Investor;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxBlockInvestor;

public final class TxBlockInvestorMapper {
	
	public final static TxBlockInvestor map(Investor source ) {
		TxBlockInvestor dest = new TxBlockInvestor();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".blockInvestor");
		dest.setInvestor(LedgerConstant.PARTICIPANT_NS+".Investor#"+source.getId());
		return dest;
	}
}
