package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.TaskPlan;
import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.epa.service.TaskPlanService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

	@ApiOperation("取得当前登录用户任务数据")
	@GetMapping("/tasks")
	public Result<TaskPlan> tasks() {
		User user = getCurrentUser();
		return success("读取数据成功", service.findByWorker(user.getId()));
	}
}
