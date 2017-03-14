package com.xcesys.extras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xcesys.extras.framework.util.ApplicationEnvironmentUtils;

@ControllerAdvice
public class ApplicationControllerAdvice {

	@Value("${application.environment}")
	private String applicationEnvironment;
	@Value("${application.name}")
	private String applicationName;
	@Value("${application.version}")
	private String applicationVersion;

	@ModelAttribute("applicationEnvironment")
	public String getApplicationEnvironment() {
		return applicationEnvironment;
	}

	@ModelAttribute("applicationName")
	public String getApplicationName() {
		return applicationName;
	}

	@ModelAttribute("applicationVersion")
	public String getApplicationVersion() {
		return applicationVersion;
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
