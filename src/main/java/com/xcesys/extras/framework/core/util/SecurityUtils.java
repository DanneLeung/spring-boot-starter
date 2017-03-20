package com.xcesys.extras.framework.core.util;

import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.xcesys.extras.framework.entity.User;

public class SecurityUtils {
	private static Set<String> getAuthorities() {
		return AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
	}

	public final static Long getLoginUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof User) {
			return ((User) principal).getId();
		}
		return null;
	}

	public final static String getLoginUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			if (authentication instanceof AbstractAuthenticationToken) {
				return ((AbstractAuthenticationToken) authentication).getName();
			} else if (authentication instanceof UsernamePasswordAuthenticationToken) {
				return ((UsernamePasswordAuthenticationToken) authentication).getName();
			} else if (authentication instanceof RememberMeAuthenticationToken) {
				return ((User) ((RememberMeAuthenticationToken) authentication).getPrincipal()).getUsername();
			}
		}
		return null;
	}

	public static User getUser() {
		// Check authentication exists
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}

		// Get user
		Object principal = authentication.getPrincipal();
		if (principal instanceof User) {
			return (User) principal;
		}

		throw new RuntimeException("Unable to get user. Unknown user type found in SecurityContextHolder's principal = "
				+ ReflectionToStringBuilder.toString(principal));
	}

	public static boolean hasAnyAuthority(String... authorities) {
		return hasAnyRole(authorities);
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

	public static boolean hasAuthority(String authority) {
		return hasRole(authority);
	}

	public static boolean hasRole(String role) {
		return getAuthorities().contains(role);
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

	public static String encodePassword(String p) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(p);
	}

	public static void main(String[] args) {
		System.out.println(SecurityUtils.encodePassword("123456"));
	}

}
