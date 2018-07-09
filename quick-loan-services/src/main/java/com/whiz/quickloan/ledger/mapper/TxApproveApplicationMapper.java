package com.whiz.quickloan.ledger.mapper;

import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.transactions.TxApproveApplication;

public final class TxApproveApplicationMapper {
	
	public final static TxApproveApplication map(Application source ) {
		TxApproveApplication dest = new TxApproveApplication();
		dest.set$class(LedgerConstant.TRANSACTION_NS + ".approveApplication");
		dest.setApplication(LedgerConstant.ASSET_NS+".Applications#"+source.getId());
		return dest;
	}
}
