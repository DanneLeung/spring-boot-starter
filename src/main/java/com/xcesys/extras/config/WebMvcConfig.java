package com.xcesys.extras.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
//@ComponentScan(basePackages = { "com.xcesys", "springfox" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Value("${spring.application.environment}")
	private String applicationEnvironment;
	@Value("${application.version}")
	private String version;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// super.addResourceHandlers(registry);
		// if (applicationEnvironment.equals("production")) {
		// registry.addResourceHandler("/static/" + version +
		// "/**").addResourceLocations("/resources/")
		// .setCachePeriod(365 * 24 * 60 * 60);
		// } else {
		// // Don't chache
		// registry.addResourceHandler("/static/" + version +
		// "/**").addResourceLocations("/resources/")
		// .setCachePeriod(0);
		// }
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
	}
	
	
}
