/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.xcesys.extras.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xcesys.extras.entity.User;
import com.xcesys.extras.framework.exception.SystemException;
import com.xcesys.extras.framework.util.SecurityUtils;
import com.xcesys.extras.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * SpringMVC框架的基础Controller类。
 * 
 */
@Slf4j
public abstract class BaseController {

	private static final String ERROR_MESSAGE = "error";
	private static final String INFO_MESSAGE = "info";
	private static final String SUCCESS_MESSAGE = "success";
	private static final String WARN_MESSAGE = "warning";

	@Autowired
	protected UserService userService;

	/**
	 * 视图前缀
	 */
	private String viewPrefix;

	protected BaseController() {
		viewPrefix = defaultViewPrefix();
	}

	/**
	 * 往Model中追加错误信息显示于用户界面。
	 * 
	 * @param model
	 *            Model
	 * @param messages
	 *            错误信息内容
	 */
	protected void addErrorMessage(Model model, String... messages) {
		model.addAttribute(ERROR_MESSAGE, catMessages(messages));
	}

	/**
	 * @param redirectAttributes
	 * @param messages
	 */
	protected void addErrorMessage(RedirectAttributes redirectAttributes, String... messages) {
		redirectAttributes.addFlashAttribute(ERROR_MESSAGE, catMessages(messages));
	}

	/**
	 * 往Model中添加提示消息显示于用户界面中。
	 * 
	 * @param model
	 *            Model
	 * @param messages
	 *            消息
	 */
	protected void addInfoMessage(Model model, String... messages) {
		model.addAttribute(INFO_MESSAGE, catMessages(messages));
	}

	/**
	 * 添加Flash消息
	 * 
	 * @param messages
	 *            消息
	 */
	protected void addInfoMessage(RedirectAttributes redirectAttributes, String... messages) {
		redirectAttributes.addFlashAttribute(INFO_MESSAGE, catMessages(messages));
	}

	/**
	 * 添加Model消息
	 * 
	 * @param messages
	 *            消息
	 */
	protected void addSuccessMessage(Model model, String... messages) {
		model.addAttribute(SUCCESS_MESSAGE, catMessages(messages));
	}

	/**
	 * 添加Flash消息
	 * 
	 * @param messages
	 *            消息
	 */
	protected void addSuccessMessage(RedirectAttributes redirectAttributes, String... messages) {
		redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE, catMessages(messages));
	}

	protected void addWarnMessage(Model model, String... messages) {
		model.addAttribute(WARN_MESSAGE, catMessages(messages));
	}

	protected void addWarnMessage(RedirectAttributes redirectAttributes, String... messages) {
		redirectAttributes.addFlashAttribute(WARN_MESSAGE, catMessages(messages));
	}

	protected String catMessages(String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		return sb.toString();
	}

	/**
	 * RequestMapping的路径默认为View JSP的前缀
	 * 
	 * @return
	 */
	protected String defaultViewPrefix() {
		String prefix = "pages";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			prefix += requestMapping.value()[0];
		}
		return prefix;
	}

	/**
	 * Returns the current logged in user's user name.
	 * 
	 * @return logged in user name.
	 */
	public Long getLoggedInUserId() {
		Long userId = SecurityUtils.getLoginUserId();
		if (userId != null) {
			return userId;
		} else {
			String username = getLoggedInUsername();
			User user = userService.findByUsername(username);
			if (user != null) {
				return user.getId();
			}
		}
		throw new SystemException("Can not get logged in user id, user may not log in system yet.");
	}

	/**
	 * Returns the current logged in user's user name.
	 * 
	 * @return logged in user name.
	 */
	public String getLoggedInUsername() {
		return SecurityUtils.getLoginUsername();
	}

	/**
	 * 返回视图文件的前缀。
	 * <p>
	 * 例如：前缀返回为user,则user list的视图可通过view("List")返回为userList.jsp
	 * </p>
	 * 
	 * @return
	 * @see #view(String)
	 */
	public String getViewPrefix() {
		return viewPrefix;
	}

	public void setMethod(Model model, String method) {
		model.addAttribute("method", method);
	}

	/**
	 * 获取视图名称：即prefixViewName + "/" + suffixName
	 * <p>
	 * 例如：前缀返回为user,则user list的视图可通过view("List")返回为userList.jsp
	 * </p>
	 * 
	 * @return
	 */
	public String view(String suffixName) {
		if (!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}
		return getViewPrefix() + suffixName;
	}
}
