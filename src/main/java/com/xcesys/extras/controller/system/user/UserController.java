package com.xcesys.extras.controller.system.user;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.entity.User;
import com.xcesys.extras.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController {
	@Autowired(required = false)
	PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
	@Autowired
	private UserService userService;

	@ResponseBody
	@JsonView(DataTablesOutput.View.class)
	@GetMapping(value = "/datatable")
	public DataTablesOutput<User> datatable(@Valid DataTablesInput input) {
		return userService.findAll(input);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return "pages/system/user/form";
	}

	@GetMapping("/edit")
	public String edit(Model model) {
		return "pages/system/user/form";
	}

	@ResponseBody
	@RequestMapping(value = "enable")
	public String enable(Long[] ids) {
		int count = 0;
		if (count > 0) {
			return "true";
		}
		return "false";
	}

	@ModelAttribute("m")
	public User get(Model model, @RequestParam(required = false) Long id) {
		User user = null;
		if (id != null) {
			user = userService.findOne(id);
		} else {
			user = this.newModel();
		}
		if (user != null && !user.isNuw()) {
			// model.addAttribute("roleList", roleService.findAll());
		}
		return user;
	}

	@GetMapping(value = { "", "/" })
	public String list(Model model) {
		return "pages/system/user/list";
	}

	protected User newModel() {
		User user = new User();
		return user;
	}

	protected void saveModel(User m, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		// 保存用户信息
		// String oldUsername = request.getParameter("oldUsername");
		String newPassword = request.getParameter("newPassword");
		if (!StringUtils.isBlank(newPassword)) {
			m.setPassword(passwordEncoder.encode(newPassword));
		}

		// 角色变更
		// String[] ids = request.getParameterValues("ids");
		// if (ids != null && ids.length > 0) {
		// Long[] longs = (ids);
		// List<Role> roles = roleService.findByIds(longs);
		// m.getRoles().clear();
		// m.getRoles().addAll(roles);
		// } else {
		// m.getRoles().clear();
		// }
		userService.create(m);
	}
}
