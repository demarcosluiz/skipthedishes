package com.skip.dao.service;

/**
 * @author Marcos.Gregorio
 *
 */
public class QueryNoResultException extends ServiceException {
	
	private static final long serialVersionUID = 1L;

	public QueryNoResultException() {
		super();
	}

	public QueryNoResultException(int errorCode, String message) {
		super(errorCode, message);
	}

	public QueryNoResultException(int errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public QueryNoResultException(int errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}
	
	public QueryNoResultException(int errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(errorCode, message, cause, enableSuppression, writableStackTrace);
	}

}
