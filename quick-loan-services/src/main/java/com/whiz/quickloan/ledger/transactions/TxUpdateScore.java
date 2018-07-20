package com.whiz.quickloan.ledger.transactions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TxUpdateScore extends BaseDomain {

	public String customer;
	public int score;
	
	public TxUpdateScore() {
		super();
	}

	/**
	 * @param customer
	 */
	public TxUpdateScore(String $class) {
		super();
		this.$class = $class;
	}
}
