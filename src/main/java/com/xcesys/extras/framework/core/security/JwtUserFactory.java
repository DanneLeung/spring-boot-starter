package com.xcesys.extras.framework.core.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(Long id, String username, String password, List<String> authorities, Boolean enabled,
			Object details) {
		return new JwtUser(id, username, password, mapToGrantedAuthorities(authorities), enabled, details);
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority))
				.collect(Collectors.toList());
	}
}
