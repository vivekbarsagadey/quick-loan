package com.whiz.quickloan.user.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.whiz.quickloan.core.domain.BaseEntity;

import lombok.Data;
 
@Entity
@Data
public class UserRole extends BaseEntity {
		
	private String name;	
 
	UserRole() { 
	} 
 
	public UserRole(String name) { 
		this.name = name; 
	} 
 
	public String getName() { 
		return name; 
	} 
 
	public void setName(String name) { 
		this.name = name; 
	} 
}