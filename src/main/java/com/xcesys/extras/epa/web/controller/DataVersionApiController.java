package com.xcesys.extras.epa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.DataVersion;
import com.xcesys.extras.epa.service.DataVersionService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

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
	protected DataVersion newModel() {
		return new DataVersion();
	}

	@Override
	protected ICrudService<DataVersion, Long> getCrudService() {
		return service;
	}
}
