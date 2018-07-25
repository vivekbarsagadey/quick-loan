package com.whiz.quickloan.customer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.whiz.quickloan.core.domain.BaseEntityAudit;
import com.whiz.quickloan.user.domain.User;

import lombok.Data;

@Entity
@Data
public class Customer extends BaseEntityAudit{
	
	@Column
	private int score;
	@Enumerated(EnumType.STRING)
	private CustomerStatus status;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private UserDetails userDetails;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private AddressDetails addressDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private ContactDetails contactDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private EmploymentDetails employmentDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private PaymentDetails paymentDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private LoanDetails loanDetails;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private BankDetails bankDetails;
	
	
	public void updateCustomer(Customer customer) {
		
		this.score = customer.score;
		this.status = customer.status;
		this.addressDetails.updateAddressDetails(customer.addressDetails);
		this.contactDetails.updateContactDetails(customer.contactDetails);
		this.bankDetails.updateBankDetails(customer.bankDetails);
		this.employmentDetails.updateEmploymentDetails(customer.employmentDetails);
		this.loanDetails.updateLoanDetails(customer.loanDetails);
		this.paymentDetails.updatePaymentDetails(customer.paymentDetails);
		this.userDetails.updateUserDetails(customer.userDetails);
		
	}
	
	
}
