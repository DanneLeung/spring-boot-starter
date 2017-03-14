package com.xcesys.extras.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.xcesys.extras.config.springsecurity.SpringDataTokenRepositoryImpl;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	static final String REMEMBER_ME_KEY = "78780c25-1849-4796-a79c-0f4326f32dfd";
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		  http
//          .headers() 
          // TODO: (REWRITE) This enables opening javamelody in an iframe, see https://jira.spring.io/browse/SEC-2501 and https://jira.spring.io/browse/SPR-11496
//              .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
//              .and()
//          .requiresChannel()
//              .anyRequest()
//              .requiresInsecure()
//              .and()
          .authorizeRequests()
//              .expressionHandler(webSecurityExpressionHandler())
			  .antMatchers("/admin/**").hasRole("ADMIN")
			  .antMatchers("/database/**").access("hasRole('DEVELOPER') and !isProductionEnvironment()")
			  .antMatchers("/javamelody/**").access("hasRole('DEVELOPER')")
			  .anyRequest().authenticated()
			  .and()
          .formLogin()
              .loginPage("/login")
              
	          .permitAll()
              .usernameParameter("username")
              .passwordParameter("password")
              .failureUrl("/login/fail")
              .defaultSuccessUrl("/login/success")
              .and()
          .logout()
              .logoutUrl("/logout")
              .logoutSuccessUrl("/logout/success")
              .invalidateHttpSession(true)
              .and()
          .rememberMe()
              .tokenRepository(springDataTokenRepository())
              .useSecureCookie(true)
              .and()
          .exceptionHandling()
              .accessDeniedPage("/error")
              .and()
//          .anonymous()
//          .and()
//          .addFilterBefore(anonymousAuthenticationFilter(), AnonymousAuthenticationFilter.class)
//          .addFilter(switchUserFilter())
//          .addFilterAfter(mdcUsernameInsertingFilter(), SecurityContextPersistenceFilter.class)
//          .authorizeRequests()
//              .expressionHandler(webSecurityExpressionHandler())
//              .antMatchers("/switchuserto").hasRole("ROOT")
//              .and()
          .csrf().disable()
          .httpBasic();
	}


	@Bean
	public SpringDataTokenRepositoryImpl springDataTokenRepository() {
		SpringDataTokenRepositoryImpl springDataTokenRepository = new SpringDataTokenRepositoryImpl();
		return springDataTokenRepository;
	}
//
//	@Bean
//	public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
//		RememberMeAuthenticationProvider rememberMeAuthenticationProvider = new RememberMeAuthenticationProvider(
//				REMEMBER_ME_KEY);
//		return rememberMeAuthenticationProvider;
//	}

	// @Bean
	// public CustomWebSecurityExpressionHandler webSecurityExpressionHandler()
	// {
	// CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler =
	// new CustomWebSecurityExpressionHandler();
	// return customWebSecurityExpressionHandler;
	// }

//	@Bean
//	public UserDetailsServiceAnonymousAuthenticationFilter anonymousAuthenticationFilter() {
//		UserDetailsServiceAnonymousAuthenticationFilter anonymousAuthenticationFilter = new UserDetailsServiceAnonymousAuthenticationFilter(
//				userDetailService);
//		return anonymousAuthenticationFilter;
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// .expressionHandler(webSecurityExpressionHandler())
		web.ignoring().antMatchers("/static/**").antMatchers("/static-*/**");
	}
}
