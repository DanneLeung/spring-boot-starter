package com.xcesys.extras.epa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.epa.service.TaskService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 任务数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "任务数据")
@RestController
@RequestMapping("/api/task")
public class TaskApiController extends BaseApiController<Task, Long> {
	@Autowired
	TaskService service;

	@Override
	protected Task newModel() {
		return new Task();
	}

	@Override
	protected ICrudService<Task, Long> getCrudService() {
		return service;
	}
}
