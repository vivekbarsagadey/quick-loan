package com.whiz.quickloan.user.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.whiz.quickloan.core.domain.BaseEntityAudit;

import lombok.Data;

@Entity
@Data
public class User extends BaseEntityAudit{
	
	//private String firstName;
	//private String lastName;
	//private String username;
	@Column(name="email_id")
	private String emailId;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<UserRole> roles;

}
