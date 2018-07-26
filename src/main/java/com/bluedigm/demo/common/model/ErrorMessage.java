package com.bluedigm.demo.common.model;

/**
 * The type Error message.
 */
public class ErrorMessage {

	private String status;

	private String code;

	private String message;


	public ErrorMessage(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}


	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets message.
	 *
	 * @param message the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage{" +
				"status='" + status + '\'' +
				", code='" + code + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
