package com.whiz.quickloan.investor.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.models.auth.In;
import lombok.Data;

@Entity
@Data
public class Investor extends BaseEntityAudit{
	
	private String companyName;
	@Enumerated(EnumType.STRING)
	private InvestorStatus status;
	private Double totalLoanLent = 0.0;
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

	public void updateInvestor(Investor investor) {

		this.companyName = investor.companyName;
		this.status = investor.status;
		this.totalLoanLent = investor.totalLoanLent;
		this.loanRange = investor.loanRange;
		
		this.addressDetails.updateAddressDetails(investor.addressDetails);
		this.bankDetails.updateBankDetails(investor.bankDetails);
		this.contactDetails.updateContactDetails(investor.contactDetails);
		this.paymentDetails.updatePaymentDetails(investor.paymentDetails);
	}
		
}
