package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxRejectApplication;

public final class TxRejectApplicationMapper {

	public final static TxRejectApplication map(Application source ) {
		TxRejectApplication dest = new TxRejectApplication();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".rejectApplication");
		dest.setApplication(LedgerConstant.ASSET_NS+".Applications#"+source.getId());
		//dest.setRemarks(source.getRemarks());
		dest.setRemarks(LedgerConstant.ASSET_NS+".Applications#"+source.getRemarks());
		return dest;
	}
}
