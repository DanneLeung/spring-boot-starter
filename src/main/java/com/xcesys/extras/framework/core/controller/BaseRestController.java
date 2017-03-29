package com.xcesys.extras.framework.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.exception.ApplicationException;

public abstract class BaseRestController {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody Result exceptionHandler(HttpServletRequest request, HttpServletResponse response,
			Exception e) {
		if (e instanceof ApplicationException) {
			return new Result(1, e.getLocalizedMessage());
		} else {
			return new Result(1, e.getLocalizedMessage());
		}
	}
}