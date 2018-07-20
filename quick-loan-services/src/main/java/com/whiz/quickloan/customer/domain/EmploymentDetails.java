package com.whiz.quickloan.customer.domain;

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
public class EmploymentDetails extends BaseEntityAudit{
	
	private String companyName;

	@Enumerated(EnumType.STRING)
	private IncomeType incomeType;

	private String employerName;
    private int currentEmployedDuration;
    private String companyAddress;
    private String jobTitle;
    private String employerPhone;
    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;


	public void updateEmploymentDetails(EmploymentDetails employmentDetails) {

		this.companyName = employmentDetails.companyName;
		this.incomeType = employmentDetails.incomeType;
		this.employerName = employmentDetails.employerName;
		this.currentEmployedDuration = employmentDetails.currentEmployedDuration;
		this.companyAddress = employmentDetails.companyAddress;
		this.jobTitle = employmentDetails.companyName;
		this.employerPhone = employmentDetails.employerPhone;
	}
}
