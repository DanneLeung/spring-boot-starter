package com.xcesys.extras.config.springsecurity;

import static com.xcesys.extras.util.ApplicationUtils.getSession;
import static com.xcesys.extras.util.ApplicationUtils.getUser;
import static com.xcesys.extras.util.ApplicationUtils.getUsername;
import static com.xcesys.extras.util.StringUtils.quote;
import static com.xcesys.extras.util.TimeUtils.format;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;
import org.springframework.stereotype.Component;

import com.xcesys.extras.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginListener {

	@Component
	static class FormLoginAndRememberMeLoginListener
			implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

		@Autowired
		LoginListener listener;

		@Override
		public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
			getSession().setAttribute("username", getUsername());
			log.info("Logged in as {}", quote(getUsername()));
			listener.onLogin(getUser());
		}
	}

	@Component
	static class SwitchUserLoginListener implements ApplicationListener<AuthenticationSwitchUserEvent> {

		@Autowired
		LoginListener listener;

		@Override
		public void onApplicationEvent(AuthenticationSwitchUserEvent event) {
			User fromUser = (User) event.getAuthentication().getPrincipal();
			User toUser = (User) event.getTargetUser();

			log.info("Logged out as {} (switching to {})", quote(fromUser.getUsername()), quote(toUser.getUsername()));
			getSession().setAttribute("username", toUser.getUsername());
			log.info("Logged in as {} (switched from {})", quote(toUser.getUsername()), quote(fromUser.getUsername()));
			listener.onLogin(toUser);
		}
	}

	private void onLogin(User user) {
		setAutomaticLogoutTime(user.getAutomaticLogoutTime());
	}

	private void setAutomaticLogoutTime(Date automaticLogoutTime) {
		// log.info("Setting automatic logout time to {}",
		// format(automaticLogoutTime));
		// int automaticLogoutTimeInSeconds =
		// automaticLogoutTime.toStandardSeconds().getSeconds();
		getSession().setMaxInactiveInterval(20 * 60);
	}

}
