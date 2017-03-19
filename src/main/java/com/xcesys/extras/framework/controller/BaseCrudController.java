package com.xcesys.extras.framework.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseCrudController<T, ID extends Serializable> extends BaseSearchController<T, ID> {
	private static final String METHOD_ADD = "Adding";
	private static final String METHOD_EDIT = "editing";
	private static final String METHOD_VIEW = "Viewing";

	@GetMapping(value = { "add" })
	public String add(Model model) {
		setMethod(model, METHOD_ADD);
		setAdding(model, true);
		model.addAttribute("m", newModel());
		return view(getSuffix() + "_form");
	}

	@GetMapping(value = "del/{id}")
	public String del(ID id, RedirectAttributes redirectAttributes) {
		if (id != null) {
			getCrudService().delete(id);
			addSuccessMessage(redirectAttributes, "删除数据成功");
		}
		return "redirect:" + getRequestMapping() + "/";
	}

	@PostMapping(value = "del")
	public String del(ID[] ids, RedirectAttributes redirectAttributes) {
		if (ids != null && ids.length > 0) {
			for (ID id : ids)
				getCrudService().delete(id);
			addSuccessMessage(redirectAttributes, "删除数据成功");
		}
		return "redirect:" + getRequestMapping() + "/";
	}

	// @GetMapping(value = "del/{id}")
	// public String del(Model model, @ModelAttribute("m") T m,
	// RedirectAttributes redirectAttributes) {
	// if (m != null) {
	// getCrudService().delete(m);
	// addSuccessMessage(redirectAttributes, "删除数据成功");
	// }
	// return "redirect:" + getViewPrefix() + "/";
	// }

	/**
	 * 编辑
	 * 
	 * @param model
	 *            ViewModel
	 * @return
	 */
	@GetMapping(value = { "edit/{id}" })
	public String edit(@ModelAttribute("m") T m, Model model) {
		setMethod(model, METHOD_EDIT);
		setEditing(model, true);
		model.addAttribute("m", m);
		return view(getSuffix() + "_form");
	}

	/**
	 * 设置id为ids参数关联的数据为启用状态，已经启用的不受影响。
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "enable")
	public int enable(boolean enabled, ID[] ids) {
		if (ids != null && ids.length > 0) {
			return getCrudService().enable(enabled, ids);
		}
		return -1;
	}

	@ModelAttribute("m")
	public T get(Model model, @PathVariable(name = "id", required = false) T m) {
		modelAttribute(model,m);
		return m == null ? newModel() : m;
	}

	/**
	 * 返回功能后缀字符串
	 * @return
	 */
	protected String getSuffix() {
		return "";
	}

	/**
	 * 共享的验证规则 验证失败返回true
	 * 
	 * @param m
	 * @param result
	 * @return
	 */
	protected boolean hasError(T m, BindingResult result) {
		Assert.notNull(m, "Model attribute cannot be null!");
		return result.hasErrors();
	}

	@GetMapping(value = { "", "/" })
	public String list(Model model) {
		return view(getSuffix() + "_list");
	}

	protected void modelAttribute(Model model, T m) {
		
	}

	/**
	 * 创建新的model实例，重写可添加初始值等初始化工作。
	 * 
	 * @return model实例
	 */
	protected abstract T newModel();

	protected void preSave(T m, HttpServletRequest request) {
	}

	@PostMapping(value = { "save", "save/{id}" })
	public String save(Model model, @Valid @ModelAttribute("m") T m, BindingResult result, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		// 验证错误，则保持在编辑界面
		if (hasError(m, result)) {
			List<ObjectError> errors = result.getAllErrors();
			List<String> msgs = new ArrayList<String>();
			for (ObjectError err : errors) {
				msgs.add(err.getDefaultMessage());
			}
			super.addErrorMessage(model, msgs.toArray(new String[] {}));
			return edit(m, model);
		}
		try {
			preSave(m, request);
			saveModel(m, request, redirectAttributes);
		} catch (Exception e) {
			log.error("Error while saving data.", e);
			addErrorMessage(model, e.getLocalizedMessage());
			// TODO: Fixed page change logic
			return view(getSuffix() + "_form");
		}
		return "redirect:" + getRequestMapping() + "/";
	}

	/**
	 * save方法验证通过后，调用的直接保存模型记录方法。
	 * 
	 * @param m
	 * @param request
	 * @param redirectAttributes
	 */
	protected void saveModel(T m, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		getCrudService().save(m);
		addSuccessMessage(redirectAttributes, "数据保存成功!");
	}

	/**
	 * 设置Controller当前映射下为新增状态。
	 * 
	 * @param model
	 *            UI Model
	 * @param adding
	 *            true表示正在新增状态，false为非新增状态。
	 */
	protected void setAdding(Model model, boolean adding) {
		model.addAttribute("adding", adding);
	}

	/**
	 * 设置Controller当前映射下为编辑状态。
	 * 
	 * @param model
	 *            UI Model
	 * @param adding
	 *            true表示正在编辑状态，false为非编辑状态。
	 */
	protected void setEditing(Model model, boolean editing) {
		model.addAttribute("editing", editing);
	}

	/**
	 * 设置Controller当前映射下为查看状态。
	 * 
	 * @param model
	 *            UI Model
	 * @param adding
	 *            true表示正在查看状态，false为非查看状态。
	 */
	protected void setViewing(Model model, boolean viewing) {
		model.addAttribute("viewing", viewing);

	}

	@GetMapping(value = "view")
	public String view(Model model) {
		setMethod(model, METHOD_VIEW);
		setViewing(model, true);
		return view(getSuffix() + "_form");
	}

}