package com.haiyen.rehap.result;

public class UsersResult {
	 private Status status = Status.SUCCESS;
	  private String message;
	  private Object data;
	  public enum Status {
	    SUCCESS, FAILED;
	  }
	  
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	 
    
}
