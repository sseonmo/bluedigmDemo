package com.bluedigm.demo.common.exception;

import org.springframework.http.HttpStatus;


/**
 * The type Resource not found exception.
 */
public class ResourceNotFoundException extends BaseServiceException {

	private static final long serialVersionUID = -6690590508137103010L;


	private final HttpStatus httpStatus;

	/**
	 * Instantiates a new Resource not found exception.
	 *
	 * @param httpStatus the http status
	 * @param message    the message
	 */
	public ResourceNotFoundException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	/**
	 * Instantiates a new Resource not found exception.
	 *
	 * @param httpStatus the http status
	 * @param message    the message
	 * @param error      the error
	 */
	public ResourceNotFoundException(HttpStatus httpStatus, String message, Throwable error) {
		super(message, error);
		this.httpStatus = httpStatus;
	}

	/**
	 * Instantiates a new Resource not found exception.
	 *
	 * @param httpStatus the http status
	 * @param e          the e
	 */
	public ResourceNotFoundException(HttpStatus httpStatus, Throwable e) {
		super(e);
		this.httpStatus = httpStatus;
	}

	/**
	 * Gets http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
