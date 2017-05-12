package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.DataVersion;
import com.xcesys.extras.epa.service.DataVersionService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * App发行包版本数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "App发行包版本数据")
@RestController
@RequestMapping("/api/dataversion")
public class DataVersionApiController extends BaseApiController<DataVersion, Long> {
	@Autowired
	DataVersionService service;

	@Override
	protected ICrudService<DataVersion, Long> getCrudService() {
		return service;
	}
	
	@ApiOperation("取得当前各个类型数据最大版本号")
	@ApiResponse(code = 200, message = "各个类型数据最大版本号")
	@GetMapping("/maxversion")
	public Result<DataVersion> maxVersions() {
		return success("读取数据成功", service.findMaxVersion());
	}
}
