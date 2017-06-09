package com.xcesys.extras.config.auditing;

import static com.xcesys.extras.framework.core.util.SecurityUtils.getLoginUser;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.userdetails.UserDetails;

import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.framework.core.security.JwtUser;

public class AuditorProvider implements AuditorAware<User> {

	@Override
	public User getCurrentAuditor() {
		UserDetails userDetails = getLoginUser();
		return userDetails == null ? null : (User) ((JwtUser) userDetails).getDetails();
	}
}
