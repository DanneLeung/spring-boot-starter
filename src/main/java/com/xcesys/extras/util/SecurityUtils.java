package com.xcesys.extras.util;

import java.util.Set;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.xcesys.extras.entity.enums.Role;

public class SecurityUtils {

	public static boolean hasAuthority(String authority) {
		return hasRole(authority);
	}

	public static boolean hasAnyAuthority(String... authorities) {
		return hasAnyRole(authorities);
	}

	public static boolean hasRole(String role) {
		return getAuthorities().contains(role);
	}

	public static boolean hasRole(Role role) {
		return getAuthorities().contains(role.toString());
	}

	public static boolean hasAnyRole(String... roles) {
		Set<String> authorities = getAuthorities();
		for (String role : roles) {
			if (authorities.contains(role)) {
				return true;
			}
		}
		// No roles matches
		return false;
	}

	public static boolean hasAnyRole(Role... roles) {
		Set<String> authorities = getAuthorities();
		for (Role role : roles) {
			if (authorities.contains(role.toString())) {
				return true;
			}
		}
		// No roles matches
		return false;
	}

	public static boolean isAnonymous() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
		return AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}

	public static boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
		return !isAnonymous();
	}

	public static boolean isFullyAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
		return !isAnonymous() && !isRememberMe();
	}

	public static boolean isRememberMe() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}

	public static boolean isSwitchedUser() {
		return hasRole("ROLE_PREVIOUS_ADMINISTRATOR");
	}

	private static Set<String> getAuthorities() {
		return AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
	}

}
