package com.xcesys.extras.framework.exception;

/**
 * Base exception class representing framework exception.
 * 
 * @author Danne
 * 
 */
public class FrameworkException extends RuntimeException {

	private static final long serialVersionUID = 1107245411496060098L;

	private String code;

	private Object[] params;

	public FrameworkException(String code) {
		this(code, null, null);
	}

	public FrameworkException(String code, Object param) {
		this(code, new Object[] { param });
	}

	public FrameworkException(String code, Object[] params) {
		this(code, params, null);
	}

	public FrameworkException(String code, Object[] params, Throwable cause) {
		super(code, cause);
		this.code = code;
		this.params = params;
	}

	public FrameworkException(String code, Throwable cause) {
		this(code, null, cause);
	}

	public String getCode() {
		return code;
	}

	public Object[] getParams() {
		return params;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}
