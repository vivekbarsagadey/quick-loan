package com.whiz.quickloan.applications.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
public class Applications extends BaseEntityAudit{
	
	private int customerId;
	private LocalDate applicationDate;
	private String remarks;
	
}
