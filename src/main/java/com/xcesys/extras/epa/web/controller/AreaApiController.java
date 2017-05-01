package com.xcesys.extras.epa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Area;
import com.xcesys.extras.epa.service.AreaService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 区域数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "区域数据")
@RestController
@RequestMapping("/api/area")
public class AreaApiController extends BaseApiController<Area, Long> {
	@Autowired
	AreaService service;

	@Override
	protected Area newModel() {
		return new Area();
	}

	@Override
	protected ICrudService<Area, Long> getCrudService() {
		return service;
	}
}
