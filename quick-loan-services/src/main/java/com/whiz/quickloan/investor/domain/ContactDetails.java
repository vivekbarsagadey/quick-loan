package com.whiz.quickloan.investor.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity	
@Data
@Table(name = "INVESTOR_CONTACT_DETAILS")
public class ContactDetails extends BaseEntityAudit{
	
	private String companyWebsite;
	private String companyEmailId;
    private String WorkPhone1;
    private String WorkPhone2;
    private String CellPhone1;
    private String CellPhone2;
    private Boolean activeStatus;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
    @JsonIgnore
    private Investor investor;

	public void updateContactDetails(ContactDetails contactDetails) {

		this.companyWebsite = contactDetails.companyWebsite;
		this.companyEmailId = contactDetails.companyEmailId;
		this.WorkPhone1 = contactDetails.WorkPhone1;
		this.WorkPhone2 = contactDetails.WorkPhone2;
		this.CellPhone1 = contactDetails.CellPhone1;
		this.CellPhone2 = contactDetails.CellPhone2;
		this.activeStatus = contactDetails.activeStatus;
	}
}
