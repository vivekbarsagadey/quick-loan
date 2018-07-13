package com.whiz.quickloan.customer.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
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
	private int monthlyExpenses;
    private LocalDate nexTPayDay;
    private LocalDate secondPayDay;
    private int monthlyIncome;
    private String incomeSource;
    private String paymentMethod;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;
}
