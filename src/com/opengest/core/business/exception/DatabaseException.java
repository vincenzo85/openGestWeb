/**
 * DatabaseException.java
 *
 * robgion
 * www.2clever.it
 * 
 * 29 nov 2017
 * For further information please write to info@2clever.it
 */
package com.opengest.core.business.exception;

/**
 * @author robgion
 *
 */
public class DatabaseException extends Exception {

	private static final long serialVersionUID = 6986907427234845598L;

	private String errorCode;
	
	public DatabaseException() {
	}

	public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DatabaseException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public DatabaseException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public DatabaseException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

}
