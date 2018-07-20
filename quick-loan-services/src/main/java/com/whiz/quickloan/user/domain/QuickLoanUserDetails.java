package com.whiz.quickloan.user.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.whiz.quickloan.core.domain.BaseEntity;

public class QuickLoanUserDetails extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Collection<? extends GrantedAuthority> authorities;
	private String password;
	private String emailId;

	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String emailId) {
		this.emailId = emailId;
	}

	public QuickLoanUserDetails(User user) {
		this.emailId = user.getEmailId();
		this.password = user.getPassword();
		this.authorities = translate(user.getRoles());
	}

	private Collection<? extends GrantedAuthority> translate(List<UserRole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (UserRole role : roles) {
			String name = role.getName().toUpperCase();
			if (!name.startsWith("ROLE_")) {
				name = "ROLE_" + name;
			}
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return emailId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}