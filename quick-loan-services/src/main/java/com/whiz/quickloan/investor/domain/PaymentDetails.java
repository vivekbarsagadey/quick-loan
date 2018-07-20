package com.whiz.quickloan.investor.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity	
@Data
@Table(name = "INVESTOR_PAYMENT_DETAILS")
public class PaymentDetails extends BaseEntityAudit{
	
    private int rateOfInterest;
	private Boolean activeStatus;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
    @JsonIgnore
    private Investor investor;

	public void updatePaymentDetails(PaymentDetails paymentDetails) {

		this.rateOfInterest = paymentDetails.rateOfInterest;
		this.activeStatus = paymentDetails.activeStatus;
	}
}
