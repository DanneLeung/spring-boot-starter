package com.xcesys.extras.framework.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.framework.core.exception.ApplicationException;

@RestController
public abstract class BaseRestController {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ApplicationException exceptionHandler(HttpServletRequest request, HttpServletResponse response,
			Exception e) {
		if (e instanceof ApplicationException) {
			return (ApplicationException) e;
		} else {
			return new ApplicationException("e001", e.getLocalizedMessage());
		}
	}
}