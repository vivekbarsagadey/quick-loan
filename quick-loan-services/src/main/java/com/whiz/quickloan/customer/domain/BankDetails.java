package com.whiz.quickloan.customer.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity	
@Data
public class BankDetails extends BaseEntityAudit{
	
	private int abaOrRoutingNumber;
	private int accountType;
	private long accountNumber;
	private String bankPhone;
	private String bankName;
	private int durationOfBankAccount;
	private int monthlyIncome;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
    private Customer customer;
}
