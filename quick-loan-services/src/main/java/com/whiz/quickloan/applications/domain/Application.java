package com.whiz.quickloan.applications.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity
@Data
public class Application extends BaseEntityAudit{
	
	private int customerId;
	private LocalDate applicationDate;
	private String remarks;
	
	public Application() {
		super();
	}

	public Application(int id) {
		super();
		this.setId(id);	
	}	
}