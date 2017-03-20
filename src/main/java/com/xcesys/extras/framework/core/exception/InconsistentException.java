package com.xcesys.extras.framework.core.exception;

/**
 * Exception class representing business data is inconsistent state, commonly
 * used by business check exception.
 * 
 * @author Danne
 * 
 */
public class InconsistentException extends FrameworkException {
	private static final long serialVersionUID = 6145562528625520683L;

	public InconsistentException(String code) {
		super(code);
	}

	public InconsistentException(String code, Object param) {
		super(code, param);
	}

	public InconsistentException(String code, Object[] params) {
		super(code, params);
	}

	public InconsistentException(String code, Object[] params, Throwable cause) {
		super(code, params, cause);
	}

	public InconsistentException(String code, Throwable cause) {
		super(code, cause);
	}

}
