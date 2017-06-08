package com.xcesys.extras.epa.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.epa.service.DataBarService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 数据条数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "数据条数据")
@RestController
@RequestMapping("/api/databar")
public class DataBarApiController extends BaseApiController<DataBar, Long> {
	@Autowired
	DataBarService service;

	@Override
	protected ICrudService<DataBar, Long> getCrudService() {
		return service;
	}

	@ApiOperation("根据类型获取对应的数据条数据")
	@ApiResponse(code = 200, message = "数据条数据的集合")
	@GetMapping({ "/findByType" })
	public Result<DataBar> list(String type) {
		List<DataBar> databars = service.findByType(type);
		if (databars == null || databars.size() <= 0) {
			return success("读取数据成功", databars);
		}
		return success("读取数据成功", databars);
	}
}
