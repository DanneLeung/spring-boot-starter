package com.xcesys.extras.framework.core.exception;

public class SystemException extends FrameworkException {
	private static final long serialVersionUID = 6145562528625520683L;

	public SystemException(String code) {
		super(code);
	}

	public SystemException(String code, Object param) {
		super(code, param);
	}

	public SystemException(String code, Object[] params) {
		super(code, params);
	}

	public SystemException(String code, Object[] params, Throwable cause) {
		super(code, params, cause);
	}

	public SystemException(String code, Throwable cause) {
		super(code, cause);
	}

}
