package com.xcesys.extras.framework.core.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

	public static UserDetails getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication==null)
			return null;
		else
			return (UserDetails) authentication.getPrincipal();
	}

	public static String getLoginUsername() {
		return null;
	}

	public static Long getLoginUserId() {
		return null;
	}

}
