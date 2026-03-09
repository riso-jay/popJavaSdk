package com.vip.pop.base.exception;

public class PopSdkException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public PopSdkException(String message) {
		super(message);
	}
	public PopSdkException(String message, Throwable cause) {
		super(message, cause);
	}
	public PopSdkException(Throwable cause) {
		super(cause);
	}
	public PopSdkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PopSdkException() {
		super();
	}
}
