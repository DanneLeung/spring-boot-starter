package com.xcesys.extras.framework.web.controller.system;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.controller.BaseCrudController;
import com.xcesys.extras.framework.core.service.ICrudService;
import com.xcesys.extras.framework.entity.DictType;
import com.xcesys.extras.framework.service.DictTypeService;

@Controller
@RequestMapping("/system/dicttype")
public class DictTypeController extends BaseCrudController<DictType, Long> {
	@Autowired
	private DictTypeService service;

	@Override
	@ResponseBody
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@GetMapping(value = "/datatable")
	public DataTablesOutput<DictType> datatable(@Valid DataTablesInput input) {
		return service.findAll(input);
	}

	@Override
	protected ICrudService<DictType, Long> getCrudService() {
		return service;
	}

	@Override
	protected String getSuffix() {
		return "dicttype";
	}

	@Override
	protected DictType newModel() {
		DictType dicttype = new DictType();
		return dicttype;
	}

	@GetMapping(value = "unique")
	@ResponseBody
	public boolean unique(String name, String oldName) {
		if (!StringUtils.isBlank(oldName) && oldName.trim().equals(name))
			return true;
		return service.countByName(name) <= 0;
	}
}
