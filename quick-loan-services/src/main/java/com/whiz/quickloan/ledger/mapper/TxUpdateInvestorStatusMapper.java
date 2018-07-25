package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.investor.domain.Investor;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateInvestorStatus;

public class TxUpdateInvestorStatusMapper {

	public final static TxUpdateInvestorStatus map(Investor source ) {
		TxUpdateInvestorStatus dest = new TxUpdateInvestorStatus();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".updateInvestorStatus");
		dest.setInvestor(LedgerConstant.PARTICIPANT_NS +".Investor#"+source.getId());
		dest.setStatus(source.getStatus().toString());
		return dest;
	}
}
