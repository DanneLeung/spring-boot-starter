package com.xcesys.extras.epa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.WorkDate;
import com.xcesys.extras.epa.service.WorkDateService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 工作日例外数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "工作日例外数据")
@RestController
@RequestMapping("/api/workdate")
public class WorkDateApiController extends BaseApiController<WorkDate, Long> {
	@Autowired
	WorkDateService service;

	@Override
	protected WorkDate newModel() {
		return new WorkDate();
	}

	@Override
	protected ICrudService<WorkDate, Long> getCrudService() {
		return service;
	}
}
