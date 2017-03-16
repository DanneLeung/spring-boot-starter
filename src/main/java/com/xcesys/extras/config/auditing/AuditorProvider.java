package com.xcesys.extras.config.auditing;

import org.springframework.data.domain.AuditorAware;
import static com.xcesys.extras.framework.util.SecurityUtils.*;

import com.xcesys.extras.entity.User;

public class AuditorProvider implements AuditorAware<User> {

	@Override
	public User getCurrentAuditor() {
		return getUser();
	}
}
