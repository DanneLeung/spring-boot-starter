package com.xcesys.extras.framework.core.util;

import java.util.TimeZone;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.xcesys.extras.framework.core.security.JwtUser;

public class SecurityUtils {

	public static UserDetails getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		} else {
			return (UserDetails) authentication.getPrincipal();
		}
	}

	public static String getLoginUsername() {
		UserDetails user = SecurityUtils.getLoginUser();
		return user.getUsername();
	}

	public static Long getLoginUserId() {
		UserDetails user = SecurityUtils.getLoginUser();
		if (user instanceof JwtUser) {
			return ((JwtUser) user).getId();
		}
		return null;
	}

	public static void main(String[] args) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password = encoder.encodePassword("123456", "");
		System.out.println(password);
		System.out.println(TimeZone.getDefault());
	}
}
