package com.bluedigm.demo.common.exception;

import org.springframework.http.HttpStatus;


/**
 * The type Internal server exception.
 */
public class InternalServerException extends BaseServiceException {

	private static final long serialVersionUID = 4881433843204429973L;

	private final HttpStatus httpStatus;

	/**
	 * Instantiates a new Internal server exception.
	 *
	 * @param httpStatus the http status
	 * @param message    the message
	 */
	public InternalServerException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	/**
	 * Instantiates a new Internal server exception.
	 *
	 * @param httpStatus the http status
	 * @param message    the message
	 * @param error      the error
	 */
	public InternalServerException(HttpStatus httpStatus, String message, Throwable error) {
		super(message, error);
		this.httpStatus = httpStatus;
	}

	/**
	 * Instantiates a new Internal server exception.
	 *
	 * @param httpStatus the http status
	 * @param e          the e
	 */
	public InternalServerException(HttpStatus httpStatus, Throwable e) {
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
