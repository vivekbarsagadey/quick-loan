package com.whiz.quickloan.investor.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.whiz.quickloan.core.domain.BaseEntity;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity
@Data
public class Investor extends BaseEntityAudit{
	
	private String companyName;
	//private String licenseNumber;

	@Enumerated(EnumType.STRING)
	private LoanRange loanRange;
	

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "investor")
	private AddressDetails addressDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "investor")
	private BankDetails bankDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "investor")
	private ContactDetails contactDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "investor")
	private PaymentDetails paymentDetails;
		
}
