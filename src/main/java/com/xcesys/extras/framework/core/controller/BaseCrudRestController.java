package com.xcesys.extras.framework.core.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.model.IEditable;
import com.xcesys.extras.framework.core.model.IdEntity;
import com.xcesys.extras.framework.core.service.ICrudService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseCrudRestController<T extends IdEntity, ID extends Serializable> extends BaseRestController {

	public BaseCrudRestController() {
		super();
	}

	protected void addErrorMessage(String... array) {

	}

	@ResponseBody
	@GetMapping(value = "del/{id}")
	public Result<?> del(@PathVariable("id") ID id) {
		if (id != null) {
			T m = getCrudService().findById(id);
			if (m != null && m instanceof IEditable && !((IEditable) m).isEditable()) {
				return result(1, "该数据为系统固定不可编辑，请选择其他操作!");
			}
			getCrudService().delete(m);
			return result(0, "删除数据成功");
		}
		return result(1, "ID为空，没有要删除的数据!");
	}

	@ModelAttribute("m")
	public T get(Model model, @PathVariable(name = "id", required = false) T m) {
		modelAttribute(model, m);
		return m == null ? newModel() : m;
	}

	protected abstract ICrudService<T, ID> getCrudService();

	/**
	 * 返回功能后缀字符串
	 * 
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

	@GetMapping({ "/", "" })
	public String index(Model model) {
		return view("");
	}

	@JsonView(PageResult.View.class)
	@ResponseBody
	@RequestMapping(value = "list")
	public PageResult<T> list(Integer page, Integer rows) {
		Pageable pageable = new PageRequest(page > 0 ? page - 1 : 0, rows > 0 ? rows : 10);
		return page2PageResult(getCrudService().findAll(pageable));
	}

	protected void modelAttribute(Model model, T m) {

	}

	/**
	 * 创建新的model实例，重写可添加初始值等初始化工作。
	 * 
	 * @return model实例
	 */
	protected abstract T newModel();

	private PageResult<T> page2PageResult(Page<T> page) {
		PageResult<T> pr = new PageResult<T>(page.getTotalElements(), page.getContent());
		return pr;
	}

	protected void preSave(T m, HttpServletRequest request) {
	}

	private Result<?> result(Integer error, String... msg) {
		return new Result<String>(error, StringUtils.join(msg, ", "));
	}

	@ResponseBody
	@PostMapping(value = { "save", "save/{id}" })
	public Result<?> save(Model model, @Valid @ModelAttribute("m") T m, BindingResult result, HttpServletRequest request) {
		// 验证错误，则保持在编辑界面
		if (hasError(m, result)) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError err : errors) {
				addErrorMessage(err.getDefaultMessage());
			}
			return result(1, "保存数据发生错误!");
		}
		try {
			preSave(m, request);
			saveModel(m, request);
		} catch (Exception e) {
			log.error("Error while saving data.", e);
			addErrorMessage(e.getLocalizedMessage());
			return result(1, e.getLocalizedMessage());
		}
		return result(0, "保持数据成功!");
	}

	/**
	 * save方法验证通过后，调用的直接保存模型记录方法。
	 * 
	 * @param m
	 * @param request
	 * @param redirectAttributes
	 */
	protected void saveModel(T m, HttpServletRequest request) {
		m = getCrudService().save(m);
		addErrorMessage("数据保存成功!");
	}

}