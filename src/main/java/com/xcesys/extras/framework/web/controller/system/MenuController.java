package com.xcesys.extras.framework.web.controller.system;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xcesys.extras.framework.core.controller.BaseCrudController;
import com.xcesys.extras.framework.core.service.ICrudService;
import com.xcesys.extras.framework.entity.Menu;
import com.xcesys.extras.framework.service.MenuService;

@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseCrudController<Menu, Long> {
	@Autowired
	private MenuService service;
 

	@Override
	public String list(Model model, RedirectAttributes redirectAttributes) {
		// return super.list(model, redirectAttributes);
		return "redirect:" + getRequestMapping() + "/children";
	}

	@GetMapping(value = { "/children", "/children/{parentId}" })
	public String children(@PathVariable(name = "parentId", required = false) Long parentId, Model model) {
		model.addAttribute("menus", service.findByParentId(parentId));
		model.addAttribute("parentId", parentId);
		return view(getSuffix() + "_list");
	}

	@Override
	protected ICrudService<Menu, Long> getCrudService() {
		return service;
	}

	@Override
	protected String getSuffix() {
		return "menu";
	}

	@Override
	protected Menu newModel() {
		Menu menu = new Menu();
		return menu;
	}

	@GetMapping(value = "unique")
	@ResponseBody
	public boolean unique(String name, String oldName) {
		if (!StringUtils.isBlank(oldName) && oldName.trim().equals(name))
			return true;
		return service.countByName(name) <= 0;
	}
}
