package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxUpdateApplicationStatus;

public class TxUpdateApplicationStatusMapper {

	public final static TxUpdateApplicationStatus map(Application source ) {
		
		TxUpdateApplicationStatus dest = new TxUpdateApplicationStatus();	
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".updateApplicationStatus");
		dest.setApplication(LedgerConstant.ASSET_NS + ".Applications#"+source.getId());
		dest.setStatus(source.getStatus().toString());
		dest.setRemarks(source.getRemarks());
		return dest;
	}
}
