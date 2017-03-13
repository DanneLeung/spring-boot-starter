package com.xcesys.extras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Value("${application.environment}")
	private String applicationEnvironment;
	@Value("${application.version}")
	private String version;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		if (applicationEnvironment.equals("production")) {
			registry.addResourceHandler("/static/" + version + "/**").addResourceLocations("/resources/")
					.setCachePeriod(365 * 24 * 60 * 60); // 365*24*60*60 equals
															// one year
		} else {
			registry.addResourceHandler("/static/" + version + "/**").addResourceLocations("/resources/")
					.setCachePeriod(0); // Don't chache
		}
	}

}
