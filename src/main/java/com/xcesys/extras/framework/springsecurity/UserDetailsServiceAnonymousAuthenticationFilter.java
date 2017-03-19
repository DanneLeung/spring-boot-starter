package com.xcesys.extras.framework.springsecurity;

import static com.xcesys.extras.framework.util.ApplicationUtils.getSession;
import static com.xcesys.extras.framework.util.ApplicationUtils.getUsername;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

public class UserDetailsServiceAnonymousAuthenticationFilter extends GenericFilterBean implements InitializingBean {

	private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();
	private List<GrantedAuthority> authorities;
	private String key;
	private Object principal;
	private UserDetailsService userDetailsService;
	private String username;

	public UserDetailsServiceAnonymousAuthenticationFilter(UserDetailsService userDetailsService) {
		this(userDetailsService, "anonymousKey");
	}

	public UserDetailsServiceAnonymousAuthenticationFilter(UserDetailsService userDetailsService, String key) {
		this(userDetailsService, key, "anonymousUser");
	}

	public UserDetailsServiceAnonymousAuthenticationFilter(UserDetailsService userDetailsService, String key,
			String username) {
		this.userDetailsService = userDetailsService;
		this.key = key;
		this.username = username;
	}

	@Override
	public void afterPropertiesSet() {
		Assert.notNull(userDetailsService, "userDetailsService must be specified");
		Assert.hasLength(key);
		Assert.notNull(username, "Anonymous username must be set");
	}

	@Transactional(readOnly = true)
	protected Authentication createAuthentication(HttpServletRequest request) {
		// Get principal and authorities from UserDetailSertvice
		if (principal == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			principal = userDetails;
			authorities = new ArrayList(userDetails.getAuthorities());
		}

		AnonymousAuthenticationToken auth = new AnonymousAuthenticationToken(key, principal, authorities);
		auth.setDetails(authenticationDetailsSource.buildDetails(request));

		return auth;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			SecurityContextHolder.getContext().setAuthentication(createAuthentication((HttpServletRequest) req));

			getSession().setAttribute("username", getUsername());

			if (logger.isDebugEnabled()) {
				logger.debug("Populated SecurityContextHolder with anonymous token: '"
						+ SecurityContextHolder.getContext().getAuthentication() + "'");
			}
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("SecurityContextHolder not populated with anonymous token, as it already contained: '"
						+ SecurityContextHolder.getContext().getAuthentication() + "'");
			}
		}

		chain.doFilter(req, res);
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Object getPrincipal() {
		return principal;
	}

	public void setAuthenticationDetailsSource(
			AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource) {
		Assert.notNull(authenticationDetailsSource, "AuthenticationDetailsSource required");
		this.authenticationDetailsSource = authenticationDetailsSource;
	}
}
