package com.skip.dao.service;

/**
 * @author Marcos.Gregorio
 *
 */
public class ServiceException extends Exception {
	
	private int errorCode = 1;
	
	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ServiceException(int errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}
	
	public ServiceException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public ServiceException(int errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
	
	
	
}
