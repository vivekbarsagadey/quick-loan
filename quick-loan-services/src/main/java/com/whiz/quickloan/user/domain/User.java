package com.whiz.quickloan.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.whiz.quickloan.core.domain.BaseEntityAudit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
public class User extends BaseEntityAudit{
	
	private String firstName;
	private String lastName;
	private String emaidId;
	private String password;

}
