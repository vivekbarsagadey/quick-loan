package com.whiz.quickloan.applications.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity
@Data
public class Application extends BaseEntityAudit{
	
	private int customerId;
	private int investorId;
	private LocalDate applicationDate;
	private Double loanAmount = 0.0;
	private String status;
	private String state;
	private String remarks;
	
	public Application() {
		super();
	}

	public Application(int id) {
		super();
		this.setId(id);	
	}

	public void updateApplication(Application application) {
		
		this.customerId = application.customerId;
		this.investorId = application.investorId;
		this.applicationDate = application.applicationDate;
		this.loanAmount = application.loanAmount;
		this.status = application.status;
		this.state = application.state;
		this.remarks = application.remarks;
	}	
}