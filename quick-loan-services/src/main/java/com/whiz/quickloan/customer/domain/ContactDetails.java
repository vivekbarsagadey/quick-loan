package com.whiz.quickloan.customer.domain;

import java.sql.Date;

import javax.persistence.Entity;
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
    private Boolean residentialStatus;
    private Date dateOfMove;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;
}
