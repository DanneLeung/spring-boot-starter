package com.xcesys.extras.framework.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.controller.BaseCrudController;
import com.xcesys.extras.framework.core.service.ICrudService;
import com.xcesys.extras.framework.core.util.ConvertUtils;
import com.xcesys.extras.framework.entity.Dict;
import com.xcesys.extras.framework.service.DictService;
import com.xcesys.extras.framework.service.DictTypeService;

@Controller
@RequestMapping("/system/dict")
public class DictController extends BaseCrudController<Dict, Long> {
	@Autowired
	private DictService service;

	@Autowired
	private DictTypeService typeService;

	@GetMapping(value = { "add/{typeId}" })
	public String add(@PathVariable("typeId") Long typeId, Model model) {
		setMethod(model, METHOD_ADD);
		setAdding(model, true);
		Dict dict = newModel();
		model.addAttribute("typeId", typeId);
		model.addAttribute("m", dict);
		return view(getSuffix() + "_form");
	}

	@ResponseBody
	@JsonView(DataTablesOutput.View.class)
	@GetMapping(value = "/datatable")
	public DataTablesOutput<Dict> datatable(@Valid DataTablesInput input) {
		return service.findAll(input);
	}

	@Override
	@PostMapping(value = "del")
	public String del(Long[] ids, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String ret = super.del(ids, model, redirectAttributes, request);
		return ret + request.getParameter("typeId");
	}

	@Override
	@GetMapping(value = { "edit/{id}" })
	public String edit(@ModelAttribute("m") Dict m, Model model, RedirectAttributes redirectAttributes) {
		String result = super.edit(m, model, redirectAttributes);
		model.addAttribute("typeId", m.getType() == null ? "" : m.getType().getId());
		return result;
	}

	@Override
	protected ICrudService<Dict, Long> getCrudService() {
		return service;
	}

	@Override
	protected String getSuffix() {
		return "dict";
	}

	@GetMapping(value = { "/{typeId}" })
	public String list(@PathVariable("typeId") Long typeId, Model model) {
		model.addAttribute("list", service.findByTypeId(typeId));
		model.addAttribute("typeId", typeId);
		return view(getSuffix() + "_list");
	}

	protected Dict newModel() {
		Dict dict = new Dict();
		return dict;
	}

	@Override
	protected void preSave(Dict m, HttpServletRequest request) {
		String typeId = request.getParameter("typeId");
		if (typeId != null) {
			m.setType(typeService.findById(ConvertUtils.convertObjectToLong(typeId)));
		}
	}

	@Override
	@PostMapping(value = { "save", "save/{id}" })
	public String save(Model model, Dict m, BindingResult result, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		super.save(model, m, result, request, redirectAttributes);
		return "redirect:" + getRequestMapping() + "/" + m.getType().getId();
	}

	@GetMapping(value = "unique/{typeId}")
	@ResponseBody
	public boolean unique(@PathVariable("typeId") Long typeId, String name, String oldName) {
		if (!StringUtils.isBlank(oldName) && oldName.trim().equals(name))
			return true;
		return service.countByTypeIdAndName(typeId, name) <= 0;
	}
}
