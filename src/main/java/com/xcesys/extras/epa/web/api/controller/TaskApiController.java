package com.xcesys.extras.epa.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.epa.service.TaskService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 任务数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "任务数据")
@RestController
@RequestMapping("/api/task")
//@Log
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

	@ApiOperation("更新指定id数组对应的任务数据为已领取状态")
	@PostMapping("/claim")
	public Result<Task> claim(@ApiParam(name = "ids") @RequestBody(required = true) List<Long> ids) {
		User user = getCurrentUser();
		int updated = service.claim(user.getId(), ids);
		Result<Task> result = success("任务数据领取状态更新成功", null);
		result.setUpdated(updated);
		return result;
	}

	@ApiOperation("更新指定id数组对应的任务数据为已提交状态")
	@PostMapping("/finish")
	public Result<Task> finish(@ApiParam(name = "ids") @RequestBody(required = true) List<Long> ids) {
		User user = getCurrentUser();
		int updated = service.finish(user.getId(), ids);
		Result<Task> result = success("任务数据提交状态更新成功", null);
		result.setUpdated(updated);
		return result;
	}
}
