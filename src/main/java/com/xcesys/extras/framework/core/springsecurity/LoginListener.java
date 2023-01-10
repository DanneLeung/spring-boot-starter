package com.xcesys.extras.framework.core.springsecurity;

import com.xcesys.extras.framework.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;
import org.springframework.stereotype.Component;

import static com.xcesys.extras.framework.core.util.ApplicationUtils.*;

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
      log.info("Logged in as {}", getUsername());
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

      log.info("Logged out as {} (switching to {})", fromUser.getUsername(), toUser.getUsername());
      getSession().setAttribute("username", toUser.getUsername());
      log.info("Logged in as {} (switched from {})", toUser.getUsername(), fromUser.getUsername());
      listener.onLogin(toUser);
    }
  }

  private void onLogin(User user) {
    // setAutomaticLogoutTime(new Period(user.getAutomaticLogoutTime()));
  }


}
