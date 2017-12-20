package com.model;

public class responseMessage {
	private String message;
	private int status;
	private companyModel data;
	  
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public companyModel getData() {
		return data;
	}

	public void setData(companyModel data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

 
}
