package com.whiz.quickloan.investor.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity	
@Data
@Table(name = "INVESTOR_BANK_DETAILS")
public class BankDetails extends BaseEntityAudit{
	
	private int abaOrRoutingNumber;
	private Long accountNumber;
	private int accountType;
	private String bankName;
	private String bankPhone;
	private int durationOfBankAccount;
	private Boolean activeStatus;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
	@JsonIgnore
	private Investor investor;
}
