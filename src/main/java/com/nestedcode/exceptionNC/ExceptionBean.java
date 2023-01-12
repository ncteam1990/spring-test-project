package com.nestedcode.exceptionNC;

public class ExceptionBean {

	private String message;
	private String status;
	private String url;
	
	public ExceptionBean() {
		
	}
	public ExceptionBean(String message, String status, String url) {
		super();
		this.message = message;
		this.status = status;
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
