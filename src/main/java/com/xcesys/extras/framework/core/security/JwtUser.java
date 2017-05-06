package com.xcesys.extras.framework.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 */
@Data
public class JwtUser implements UserDetails {

	private static final long serialVersionUID = -8500813685988190279L;
	private Long id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean enabled;
	private Object details;

	public JwtUser(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities,
			boolean enabled, Object details) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.enabled = enabled;
		this.details = details;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
