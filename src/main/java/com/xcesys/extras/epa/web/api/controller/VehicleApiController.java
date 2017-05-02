package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Vehicle;
import com.xcesys.extras.epa.service.VehicleService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 车型数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "车型数据")
@RestController
@RequestMapping("/api/vehicle")
public class VehicleApiController extends BaseApiController<Vehicle, Long> {
	@Autowired
	VehicleService service;

	@Override
	protected ICrudService<Vehicle, Long> getCrudService() {
		return service;
	}
}
