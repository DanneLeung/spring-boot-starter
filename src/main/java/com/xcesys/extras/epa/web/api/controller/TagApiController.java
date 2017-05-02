package com.xcesys.extras.epa.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Tag;
import com.xcesys.extras.epa.service.TagService;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 标签数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "标签数据")
@RestController
@RequestMapping("/api/tag")
public class TagApiController extends BaseApiController<Tag, Long> {
	@Autowired
	TagService service;

	@Override
	protected ICrudService<Tag, Long> getCrudService() {
		return service;
	}
}
