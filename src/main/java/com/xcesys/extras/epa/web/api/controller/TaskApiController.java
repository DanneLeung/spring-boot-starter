package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@ApiOperation("更新指定id数组对应的任务数据为已领取状态")
	@PostMapping("/claim")
	public Result<Task> claim(Long[] ids) {
		User user = getCurrentUser();
		service.claim(user.getId(), ids);
		return success("任务数据领取状态更新成功", null);
	}

	@ApiOperation("更新指定id数组对应的任务数据为已提交状态")
	@PostMapping("/finish")
	public Result<Task> finish(Long[] ids) {
		User user = getCurrentUser();
		service.finish(user.getId(), ids);
		return success("任务数据提交状态更新成功", null);
	}
}
