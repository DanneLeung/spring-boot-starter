package com.xcesys.extras.web.controller.system.role;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.entity.Role;
import com.xcesys.extras.framework.controller.BaseCrudController;
import com.xcesys.extras.framework.service.ICrudService;
import com.xcesys.extras.service.RoleService;

@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseCrudController<Role, Long> {
	@Autowired
	private RoleService roleService;

	@ResponseBody
	@JsonView(DataTablesOutput.View.class)
	@GetMapping(value = "/datatable")
	public DataTablesOutput<Role> datatable(@Valid DataTablesInput input) {
		return roleService.findAll(input);
	}

	@Override
	protected String getPrefix() {
		return "user";
	}

	protected Role newModel() {
		Role role = new Role();
		return role;
	}

	@Override
	protected ICrudService<Role, Long> getCrudService() {
		return roleService;
	}
}
