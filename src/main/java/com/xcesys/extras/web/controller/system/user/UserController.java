package com.xcesys.extras.web.controller.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xcesys.extras.entity.User;
import com.xcesys.extras.framework.controller.BaseCrudController;
import com.xcesys.extras.framework.service.ICrudService;
import com.xcesys.extras.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/system/user")
@Slf4j
public class UserController extends BaseCrudController<User, Long> {
	@Autowired(required = false)
	PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
	@Autowired
	public UserService userService;

	@Override
	protected ICrudService<User, Long> getCrudService() {
		return userService;
	}
	
	@Override
	protected String getPrefix() {
		return "user";
	}

	protected User newModel() {
		User user = new User();
		return user;
	}
}
