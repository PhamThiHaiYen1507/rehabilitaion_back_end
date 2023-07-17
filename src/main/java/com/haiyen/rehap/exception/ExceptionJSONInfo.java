package com.haiyen.rehap.exception;

public class ExceptionJSONInfo {

	private int statusCode;
	private String message;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionJSONInfo(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public ExceptionJSONInfo(String message) {
		super();
		this.message = message;
	}

	public ExceptionJSONInfo() {
	}

}