package com.xcesys.extras.controller.system.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.entity.User;
import com.xcesys.extras.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = { "", "/" })
	public String list(Model model) {
		return "pages/system/user/list";
	}

	@ResponseBody
	@JsonView(DataTablesOutput.View.class)
	@GetMapping(value = "/datatable")
	public DataTablesOutput<User> datatable(@Valid DataTablesInput input) {
		return userService.findAll(input);
	}
}
