package com.xcesys.extras.epa.web.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.Area;
import com.xcesys.extras.epa.entity.AreaDatabarTag;
import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.epa.entity.Tag;
import com.xcesys.extras.epa.service.AreaDatabarTagService;
import com.xcesys.extras.epa.service.AreaService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 区域数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "区域数据")
@RestController
@RequestMapping("/api/area")
//@Log
public class AreaApiController extends BaseApiController<Area, Long> {
	@Autowired
	AreaService service;
	@Autowired
	AreaDatabarTagService tagService;

	@ApiIgnore
	protected Area newModel() {
		return new Area();
	}

	@Override
	@ApiIgnore
	protected ICrudService<Area, Long> getCrudService() {
		return service;
	}

	@ApiOperation("取得区域，数据条，标签关联所有可用数据")
	@ApiResponse(code = 200, message = "区域，数据条，标签关联数据的集合")
	@GetMapping({ "/all" })
	public Result<Area> all(
			@RequestParam(name = "areaId", required = false) @ApiParam(name = "areaId", required = false) Long areaId) {
		Iterable<Area> areas = areaId == null ? getCrudService().findAll()
				: Arrays.asList(getCrudService().findById(areaId));
		Map<String, List<Tag>> maps = new HashMap<String, List<Tag>>();
		List<AreaDatabarTag> areaDatabarTags = tagService.findList();
		for (AreaDatabarTag adt : areaDatabarTags) {
			String key = adt.getArea() + "_" + adt.getDatabar();
			List<Tag> tags = maps.get(key);
			if (tags == null) {
				tags = new ArrayList<Tag>();
				maps.put(key, tags);
			}
			tags.add(adt.getTag());
		}

		for (Area area : areas) {
			Set<DataBar> databars = area.getDatabars();
			for (DataBar dataBar : databars) {
				if (dataBar == null)
					continue;
				dataBar.setTags(maps.get(area.getId() + "_" + dataBar.getId()));
			}
		}
		return success("读取数据成功", areas);
	}
}
