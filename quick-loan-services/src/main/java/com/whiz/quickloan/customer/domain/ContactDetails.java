package com.whiz.quickloan.customer.domain;

import java.sql.Date;

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
public class ContactDetails extends BaseEntityAudit{

	private String emailId;
	private String confirmEmail;
	private String password;
	private String confirmPassword;
    private String workPhone;
    private String homePhone1;
    private String homePhone2;
    private String homePhone3;
    private String cellPhone1;
    private String cellPhone2;
    private String cellPhone3;
    @Enumerated(EnumType.STRING)
    private ResidentialStatus residentialStatus;
    private Date dateOfMove;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

	public void updateContactDetails(ContactDetails contactDetails) {

		this.emailId = contactDetails.emailId;
		this.confirmEmail = contactDetails.confirmEmail;
		this.password = contactDetails.password;
		this.confirmPassword = contactDetails.confirmPassword;
		this.workPhone = contactDetails.workPhone;
		this.homePhone1 = contactDetails.homePhone1;
		this.homePhone2 = contactDetails.homePhone2;
		this.homePhone3 = contactDetails.homePhone3;
		this.cellPhone1 = contactDetails.cellPhone1;
		this.cellPhone2 = contactDetails.emailId;
		this.cellPhone3 = contactDetails.cellPhone3;
		this.residentialStatus = contactDetails.residentialStatus;
		this.dateOfMove = contactDetails.dateOfMove;
	}
}
