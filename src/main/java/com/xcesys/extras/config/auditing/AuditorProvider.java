package com.xcesys.extras.config.auditing;

import static com.xcesys.extras.framework.util.SecurityUtils.getLoginUsername;

import org.springframework.data.domain.AuditorAware;

public class AuditorProvider implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return getLoginUsername();
	}
}
