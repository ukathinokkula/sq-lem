package com.lem.service.config.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.lem.service.model.User;

@Component
public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public SecurityUser() {
		// TODO Auto-generated constructor stub
	}

	public SecurityUser(User user) {
		if (user != null) {
			this.setId(user.getId());
			this.setUsername(user.getUsername().trim());
			this.setRoleName(user.getRoleName());
			this.setPassword(user.getPassword());
		}
	}

	/*
	 * public Collection<? extends GrantedAuthority> getAuthorities() {
	 * Collection<GrantedAuthority> authorities = new ArrayList<>();
	 * 
	 * Set<Role> userRoles = this.getRoles(); if (userRoles != null) { for (Role
	 * role : userRoles) { SimpleGrantedAuthority authority = new
	 * SimpleGrantedAuthority( role.getRoleName()); authorities.add(authority);
	 * } } SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
	 * this.getRole_name());
	 * System.out.println("Authority "+authority.getAuthority());
	 * authorities.add(authority); return authorities; }
	 */

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();

		/*
		 * Set<User> userRoles = this.getRoles(); if (userRoles != null) { for
		 * (Role role : userRoles) { SimpleGrantedAuthority authority = new
		 * SimpleGrantedAuthority( role.getRoleName());
		 * authorities.add(authority); } }
		 */

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
				this.getRoleName());
		System.out.println("Authority " + authority.getAuthority());
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
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
