package com.xcesys.extras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xcesys.extras.framework.core.util.ApplicationEnvironmentUtils;

@ControllerAdvice
public class ApplicationControllerAdvice {

	@Value("${spring.application.environment}")
	private String applicationEnvironment;
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${application.version}")
	private String applicationVersion;
	@Value("${application.theme}")
	private String theme;

	@ModelAttribute("theme")
	public String getTheme() {
		return theme;
	}

	@ModelAttribute("applicationEnvironment")
	public String getApplicationEnvironment() {
		return applicationEnvironment;
	}

	@ModelAttribute("applicationVersion")
	public String getApplicationVersion() {
		return applicationVersion;
	}

	@ModelAttribute("applicationName")
	public String getApplicationName() {
		return applicationName;
	}

	@ModelAttribute("isDevelopmentEnvironment")
	public boolean isDevelopmentEnvironment() {
		return ApplicationEnvironmentUtils.isDevelopmentEnvironment();
	}

	@ModelAttribute("isLocalhostEnvironment")
	public boolean isLocalhostEnvironment() {
		return ApplicationEnvironmentUtils.isLocalhostEnvironment();
	}

	@ModelAttribute("isProductionEnvironment")
	public boolean isProductionEnvironment() {
		return ApplicationEnvironmentUtils.isProductionEnvironment();
	}

	@ModelAttribute("isTestEnvironment")
	public boolean isTestEnvironment() {
		return ApplicationEnvironmentUtils.isTestEnvironment();
	}
}
