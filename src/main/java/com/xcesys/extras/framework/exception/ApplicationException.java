package com.xcesys.extras.framework.exception;

public class ApplicationException extends FrameworkException {
	private static final long serialVersionUID = 6145562528625520683L;

	public ApplicationException(String code) {
		super(code);
	}

	public ApplicationException(String code, Object param) {
		super(code, param);
	}

	public ApplicationException(String code, Object[] params) {
		super(code, params);
	}

	public ApplicationException(String code, Object[] params, Throwable cause) {
		super(code, params, cause);
	}

	public ApplicationException(String code, Throwable cause) {
		super(code, cause);
	}

}
