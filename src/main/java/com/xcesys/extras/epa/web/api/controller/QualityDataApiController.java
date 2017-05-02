package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.QualityData;
import com.xcesys.extras.epa.service.QualityDataService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 质量过程数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "质量过程数据")
@RestController
@RequestMapping("/api/qualitydata")
public class QualityDataApiController extends BaseApiController<QualityData, Long> {
	@Autowired
	QualityDataService service;

	@Override
	protected ICrudService<QualityData, Long> getCrudService() {
		return service;
	}
}
