package com.haiyen.rehap.result;

import org.springframework.http.HttpStatus;

public class Result<T> {
	public Result() {

	}

	public Result(int statusCode, String message, T data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	private int statusCode = HttpStatus.OK.value();
	private String message = "success";
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
