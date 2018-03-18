package com.skip.dao.service;

/**
 * @author Marcos.Gregorio
 *
 */
public class DAOServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DAOServiceException() {
		super();
	}
	
	public DAOServiceException(String message) {
		super(message);
	}
	
	public DAOServiceException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public DAOServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DAOServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
