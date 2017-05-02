package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.PartPic;
import com.xcesys.extras.epa.service.PartPicService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 图形部件数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "图形部件数据")
@RestController
@RequestMapping("/api/partpic")
public class PartPicApiController extends BaseApiController<PartPic, Long> {
	@Autowired
	PartPicService service;

	@Override
	protected ICrudService<PartPic, Long> getCrudService() {
		return service;
	}
}
