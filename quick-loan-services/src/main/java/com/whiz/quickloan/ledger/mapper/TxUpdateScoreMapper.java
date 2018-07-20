package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateScore;

public class TxUpdateScoreMapper {

	public final static TxUpdateScore map(Customer source ) {
		TxUpdateScore dest = new TxUpdateScore();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".updateScore");
		dest.setCustomer(LedgerConstant.PARTICIPANT_NS+".Customer#"+source.getId());
		dest.setScore(source.getScore());
		return dest;
	}
}
