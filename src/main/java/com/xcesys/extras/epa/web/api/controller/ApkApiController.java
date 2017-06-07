package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Apk;
import com.xcesys.extras.epa.service.ApkService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 字典数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "APK版本数据")
@RestController
@RequestMapping("/api/apk")
public class ApkApiController extends BaseApiController<Apk, Long> {
	@Autowired
	ApkService service;

	@Override
	protected ICrudService<Apk, Long> getCrudService() {
		return service;
	}
}
