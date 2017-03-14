package com.xcesys.extras.config.springsecurity;

import static com.xcesys.extras.framework.util.StringUtils.quote;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent> {

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		String sessionId = (String) ((HttpSessionDestroyedEvent) event).getSession().getId();
		String username = (String) ((HttpSessionDestroyedEvent) event).getSession().getAttribute("username");
		log.info("Logged out as {}", quote(username));
	}
}
