package com.xcesys.extras.config.auditing;

import com.xcesys.extras.framework.core.util.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorProvider implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityUtils.getLoginUsername());
	}
}
