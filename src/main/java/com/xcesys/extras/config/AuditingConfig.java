package com.xcesys.extras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.xcesys.extras.config.auditing.AuditorProvider;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorProvider();
    }
}
