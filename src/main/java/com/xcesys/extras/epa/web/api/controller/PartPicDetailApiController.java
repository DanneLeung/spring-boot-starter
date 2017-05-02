package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.PartPicDetail;
import com.xcesys.extras.epa.service.PartPicDetailService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 图形部件明细数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "图形部件明细数据")
@RestController
@RequestMapping("/api/partpicdetail")
public class PartPicDetailApiController extends BaseApiController<PartPicDetail, Long> {
	@Autowired
	PartPicDetailService service;

	@Override
	protected ICrudService<PartPicDetail, Long> getCrudService() {
		return service;
	}
}
