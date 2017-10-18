package com.briup.estore.common.exception;

public class LineException extends Exception{

	private static final long serialVersionUID = -2299443369229122943L;

	public LineException() {
		super();
	}

	public LineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LineException(String message, Throwable cause) {
		super(message, cause);
	}

	public LineException(String message) {
		super(message);
	}

	public LineException(Throwable cause) {
		super(cause);
	}
	
}
