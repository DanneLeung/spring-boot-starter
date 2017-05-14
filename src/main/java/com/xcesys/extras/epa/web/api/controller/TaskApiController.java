package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.epa.service.TaskService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	protected ICrudService<Task, Long> getCrudService() {
		return service;
	}
	

	@ApiOperation("取得当前登录用户任务数据")
	@GetMapping("/tasks")
	public Result<Task> tasks() {
		User user = getCurrentUser();
		return success("读取数据成功", service.findByWorker(user.getId()));
	}
}
