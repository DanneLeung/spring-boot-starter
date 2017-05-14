package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.DictType;
import com.xcesys.extras.epa.service.DictService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 字典数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "字典数据")
@RestController
@RequestMapping("/api/dict")
public class DictApiController extends BaseApiController<DictType, Long> {
	@Autowired
	DictService service;

	@Override
	protected ICrudService<DictType, Long> getCrudService() {
		return service;
	}
}
