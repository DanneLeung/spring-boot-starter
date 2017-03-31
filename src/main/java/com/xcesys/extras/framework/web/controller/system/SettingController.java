package com.xcesys.extras.framework.web.controller.system;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcesys.extras.framework.core.controller.BaseCrudController;
import com.xcesys.extras.framework.core.service.ICrudService;
import com.xcesys.extras.framework.entity.Setting;
import com.xcesys.extras.framework.service.SettingService;

@Controller
@RequestMapping("/system/setting")
public class SettingController extends BaseCrudController<Setting, Long> {
	@Autowired
	private SettingService service;
 

	@Override
	protected ICrudService<Setting, Long> getCrudService() {
		return service;
	}

	@Override
	protected String getSuffix() {
		return "setting";
	}

	@Override
	protected Setting newModel() {
		Setting setting = new Setting();
		return setting;
	}

	@GetMapping(value = "unique")
	@ResponseBody
	public boolean unique(String name, String oldName) {
		if (!StringUtils.isBlank(oldName) && oldName.trim().equals(name))
			return true;
		return service.countByName(name) <= 0;
	}
}
