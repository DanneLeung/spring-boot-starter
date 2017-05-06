package com.xcesys.extras.epa.web.api.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.exception.ApplicationException;
import com.xcesys.extras.framework.core.model.IdEntity;
import com.xcesys.extras.framework.core.security.JwtUser;
import com.xcesys.extras.framework.core.service.ICrudService;
import com.xcesys.extras.framework.core.util.SecurityUtils;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
public abstract class BaseApiController<T extends IdEntity, ID extends Serializable> {

	@ApiOperation("取得所有可用数据列表")
	@GetMapping("/list")
	public Result<T> List() {
		log.info(" Current User:" + getCurrentUser());

		return success("读取数据成功", getCrudService().findAll());
	}

	protected abstract ICrudService<T, ID> getCrudService();

	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody Result exceptionHandler(HttpServletRequest request, HttpServletResponse response,
			Exception e) {
		if (e instanceof ApplicationException) {
			return error(1, e.getLocalizedMessage());
		} else {
			return error(1, e.getLocalizedMessage());
		}
	}

	protected User getCurrentUser() {
		UserDetails userDetails = SecurityUtils.getLoginUser();
		if (userDetails instanceof JwtUser) {
			return (User) ((JwtUser) userDetails).getDetails();
		}
		return null;
	}

	protected Result<T> success(String message, Iterable<T> contents) {
		Result<T> result = new Result<T>(0, message);
		result.setContent(contents);
		return result;
	}

	protected Result<?> error(Integer errorCode, String errorMessage) {
		return new Result<>(errorCode, errorMessage);
	}
}
