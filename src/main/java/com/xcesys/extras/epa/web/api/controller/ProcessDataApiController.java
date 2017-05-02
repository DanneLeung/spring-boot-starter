package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.ProcessData;
import com.xcesys.extras.epa.service.ProcessDataService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 工艺过程数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "工艺过程数据")
@RestController
@RequestMapping("/api/processdata")
public class ProcessDataApiController extends BaseApiController<ProcessData, Long> {
	@Autowired
	ProcessDataService service;

	@Override
	protected ICrudService<ProcessData, Long> getCrudService() {
		return service;
	}
}
