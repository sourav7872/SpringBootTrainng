package com.sparc.response;



public class ApiMessageResponse {
	
	private String message;

	public ApiMessageResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
