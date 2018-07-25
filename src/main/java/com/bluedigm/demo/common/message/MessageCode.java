package com.bluedigm.demo.common.message;

public enum MessageCode implements Code{

	RESOURCE_NOT_FOUND("error.resource.not_found"),
	MESSAGE_TEST("message.test");

	private String code;

	MessageCode(String code) {
		this.code = code;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}
}
