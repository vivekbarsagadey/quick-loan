package com.whiz.quickloan.customer.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity	
@Data
public class PaymentDetails extends BaseEntityAudit{
	
	private int paymentFrequency;
	private String sortCode;
	private String bankAccount;
	private double monthlyExpenses;
    private LocalDate nexTPayDay;
    private LocalDate secondPayDay;
    private double monthlyIncome;
    @Enumerated(EnumType.STRING)
    private IncomeSource incomeSource;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

	public void updatePaymentDetails(PaymentDetails paymentDetails) {

		this.paymentFrequency = paymentDetails.paymentFrequency;
		this.sortCode = paymentDetails.sortCode;
		this.bankAccount = paymentDetails.bankAccount;
		this.monthlyExpenses = paymentDetails.monthlyExpenses;
		this.nexTPayDay = paymentDetails.nexTPayDay;
		this.secondPayDay = paymentDetails.secondPayDay;
		this.monthlyIncome = paymentDetails.monthlyIncome;
		this.incomeSource = paymentDetails.incomeSource;
		this.paymentMethod = paymentDetails.paymentMethod;
	}
}
