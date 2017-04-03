package com.saic.epa.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcesys.extras.framework.core.controller.BaseCrudRestController;
import com.xcesys.extras.framework.core.service.ICrudService;
import com.xcesys.extras.framework.entity.User;
import com.xcesys.extras.framework.service.RoleService;
import com.xcesys.extras.framework.service.UserService;

@Controller
@RequestMapping("/epa/system/user")
public class UserRestController extends BaseCrudRestController<User, Long> {
	@Autowired(required = false)
	PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
	@Autowired
	UserService service;
	@Autowired
	RoleService roleService;

	@ResponseBody
	@GetMapping(value = "resetpwd")
	public int resetpwd(Long[] ids) {
		if (ids != null && ids.length > 0) {
			return service.resetpwd(ids);
		}
		return -1;
	}

	@GetMapping(value = "unique")
	@ResponseBody
	public boolean unique(String username, String oldUsername) {
		if (!StringUtils.isBlank(oldUsername) && oldUsername.trim().equals(username))
			return true;
		return service.countByUsername(username) <= 0;
	}

	@Override
	protected User newModel() {
		return new User();
	}

	@Override
	protected ICrudService<User, Long> getCrudService() {
		return service;
	}
}
