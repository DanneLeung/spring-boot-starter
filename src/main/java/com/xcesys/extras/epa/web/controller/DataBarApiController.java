package com.xcesys.extras.epa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.epa.service.DataBarService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 数据条数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "数据条数据")
@RestController
@RequestMapping("/api/databar")
public class DataBarApiController extends BaseApiController<DataBar, Long> {
	@Autowired
	DataBarService service;

	@Override
	protected DataBar newModel() {
		return new DataBar();
	}

	@Override
	protected ICrudService<DataBar, Long> getCrudService() {
		return service;
	}
}
