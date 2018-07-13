package com.whiz.quickloan.customer.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity	
@Data
public class AddressDetails extends BaseEntityAudit{

	private String address;
	private String state;
	private String country;
    private String city;
    private String zipCode;
    private int monthsInCurrentaddress;
    private int yrsInCurrentaddress;
    
    @Enumerated(EnumType.STRING)
    private StayType stayType;
    
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;
}
