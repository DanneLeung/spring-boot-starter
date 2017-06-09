package com.xcesys.extras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.xcesys.extras.config.auditing.AuditorProvider;
import com.xcesys.extras.epa.entity.User;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new AuditorProvider();
	}
}
