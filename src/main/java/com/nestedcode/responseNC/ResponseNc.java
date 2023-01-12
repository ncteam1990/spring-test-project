package com.nestedcode.responseNC;

import java.util.Map;

public class ResponseNc {

	private Map<String, Object> mainMessage;
	private Map errorMessage;
	
	public ResponseNc(Map<String, Object> mainMessage, Map errorMessage) {
		super();
		this.mainMessage = mainMessage;
		this.errorMessage = errorMessage;
	}
	public ResponseNc() {
		
	}
	public Map<String, Object> getMainMessage() {
		return mainMessage;
	}
	public void setMainMessage(Map<String, Object> mainMessage) {
		this.mainMessage = mainMessage;
	}
	public Map getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(Map errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
