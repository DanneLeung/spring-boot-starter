package com.xcesys.extras.epa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.TaskData;
import com.xcesys.extras.epa.service.TaskDataService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 任务过程数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "任务过程数据")
@RestController
@RequestMapping("/api/taskdata")
public class TaskDataApiController extends BaseApiController<TaskData, Long> {
	@Autowired
	TaskDataService service;

	@Override
	protected TaskData newModel() {
		return new TaskData();
	}

	@Override
	protected ICrudService<TaskData, Long> getCrudService() {
		return service;
	}
}
