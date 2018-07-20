package com.whiz.quickloan.customer.domain;

import javax.persistence.CascadeType;
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
public class AddressDetails extends BaseEntityAudit{

	private String address;
	@Enumerated(EnumType.STRING)
	private State state;
	@Enumerated(EnumType.STRING)
	private Country country;
    private String city;
    private String zipCode;
    private int monthsInCurrentaddress;
    private int yrsInCurrentaddress;
    @Enumerated(EnumType.STRING)
    private StayType stayType;
    
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;



	public void updateAddressDetails(AddressDetails addressDetails) {

		this.address = addressDetails.address;
		this.state = addressDetails.state;
		this.country = addressDetails.country;
		this.city = addressDetails.city;
		this.zipCode = addressDetails.zipCode;
		this.monthsInCurrentaddress = addressDetails.monthsInCurrentaddress;
		this.yrsInCurrentaddress = addressDetails.yrsInCurrentaddress;
		this.stayType = addressDetails.stayType;
	}
}
