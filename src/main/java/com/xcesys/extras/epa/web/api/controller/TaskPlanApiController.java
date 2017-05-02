package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.TaskPlan;
import com.xcesys.extras.epa.service.TaskPlanService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 任务规则数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "任务规则数据")
@RestController
@RequestMapping("/api/taskplan")
public class TaskPlanApiController extends BaseApiController<TaskPlan, Long> {
	@Autowired
	TaskPlanService service;

	@Override
	protected ICrudService<TaskPlan, Long> getCrudService() {
		return service;
	}
}
