package com.briup.estore.common.exception;

public class CustomerException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerException() {
		super();
	}

	public CustomerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}
}
