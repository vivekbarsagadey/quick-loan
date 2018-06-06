package com.whiz.quickloan.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntityAudit extends BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Size(max = 20)
	@Column(name = "created_by", length = 20)
	private String createdBy;

	@Column(name = "updated_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Size(max = 20)
	@Column(name = "updated_by", length = 20)
	private String updatedBy;

	@PrePersist
	public void setCreationDate() {
		this.createdDate = new Date();
	}

	@PreUpdate
	public void setChangeDate() {
		this.updatedDate = new Date();
	}
}
