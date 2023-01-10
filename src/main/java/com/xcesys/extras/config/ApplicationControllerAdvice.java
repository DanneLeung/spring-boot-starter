package com.xcesys.extras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xcesys.extras.framework.core.util.ApplicationEnvironmentUtils;

@ControllerAdvice
public class ApplicationControllerAdvice {

  @Value("${spring.profiles.active}")
  private String applicationEnvironment;
  @Value("${spring.application.name}")
  private String applicationName;
  @Value("${application.version:1.0.0}")
  private String applicationVersion;
  @Value("${application.theme.uri}")
  private String theme = this.themeRoot + "/" + this.themeName;
  @Value("${application.theme.name:hyper}")
  private String themeName;
  @Value("${application.theme.root:/static/themes}")
  private String themeRoot;

  @ModelAttribute("themeRoot")
  public String getThemeRoot() {
    return themeRoot;
  }

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
