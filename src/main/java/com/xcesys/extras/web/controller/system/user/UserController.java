package com.xcesys.extras.web.controller.system.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcesys.extras.entity.Role;
import com.xcesys.extras.entity.User;
import com.xcesys.extras.framework.controller.BaseCrudController;
import com.xcesys.extras.framework.service.ICrudService;
import com.xcesys.extras.service.RoleService;
import com.xcesys.extras.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseCrudController<User, Long> {
	@Autowired(required = false)
	PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@ModelAttribute("roles")
	public Iterable<Role> getRoles(@PathVariable(name = "id", required = false) Long id) {
		return roleService.findAll();
	}

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

	@GetMapping(value = "unique")
	@ResponseBody
	public boolean unique(String username, String oldUsername) {
		if (!StringUtils.isBlank(oldUsername) && oldUsername.trim().equals(username))
			return true;
		return userService.countByUsername(username) <= 0;
	}
	
	@Override
	protected void preSave(User m, HttpServletRequest request) {
		super.preSave(m, request);
	}
}
