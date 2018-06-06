package com.whiz.quickloan.customer.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity	
@Data
public class AddressDetails extends BaseEntityAudit{
	private String zipCode;
    private String city;
    private String state;
    private String country;
    private String address;
    private int yrsInCurrentaddress;
    private int monthsInCurrentaddress;
    
    @Enumerated(EnumType.STRING)
    private StayType stayType;
    
    private Boolean activeStatus;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;
}