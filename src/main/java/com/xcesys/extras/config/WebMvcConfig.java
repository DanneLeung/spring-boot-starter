package com.xcesys.extras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
// @ComponentScan(basePackages = { "com.xcesys", "springfox" })
@Import(Swagger2Configuration.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Value("${spring.application.environment}")
	private String applicationEnvironment;
	@Value("${application.version}")
	private String version;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// super.addResourceHandlers(registry);
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
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
}
