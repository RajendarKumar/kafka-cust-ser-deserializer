/**
 * 
 */
package com.raj.kafka.exception;

/**
 * @author Rajendar
 *
 */
public class SerialazationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8733558051785519525L;

	/**
	 * 
	 */
	public SerialazationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SerialazationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SerialazationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SerialazationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SerialazationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
