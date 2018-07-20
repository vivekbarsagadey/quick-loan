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
public class UserDetails extends BaseEntityAudit {

	private String firstName;
	private String middleName;	
	private String lastName;
	private LocalDate DoB;
	private String licenseNumber;
	@Enumerated(EnumType.STRING)
	private State licState;
	private LocalDate licIssueDate;
	private LocalDate licExpirationDate;
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	@Enumerated(EnumType.STRING)
	private BestTimeToCall bestTimeToCall;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;


	public void updateUserDetails(UserDetails userDetails) {

		this.firstName = userDetails.firstName;
		this.middleName = userDetails.middleName;
		this.lastName = userDetails.lastName;
		this.DoB = userDetails.DoB;
		this.licenseNumber = userDetails.licenseNumber;
		this.licState = userDetails.licState;
		this.licIssueDate = userDetails.licIssueDate;
		this.licExpirationDate = userDetails.licExpirationDate;
		this.maritalStatus = userDetails.maritalStatus;
		this.bestTimeToCall = userDetails.bestTimeToCall;
	}
}
