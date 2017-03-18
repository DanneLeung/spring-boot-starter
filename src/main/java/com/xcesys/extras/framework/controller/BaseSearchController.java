package com.xcesys.extras.framework.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.service.ICrudService;

/**
 * @author danne
 *
 * @param <T>
 */
public abstract class BaseSearchController<T, ID extends Serializable> extends BaseController {
	@ResponseBody
	@JsonView(DataTablesOutput.View.class)
	@GetMapping(value = "datatable")
	public DataTablesOutput<T> datatable(@Valid DataTablesInput input) {
		return getCrudService().findAll(input);
	}

	protected abstract ICrudService<T, ID> getCrudService();

}