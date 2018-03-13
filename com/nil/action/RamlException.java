package com.nil.action;

public class RamlException extends Exception {
	public RamlException(String string) {
		// TODO Auto-generated constructor stub
		this.setErrorMessage(string);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private String errorMessage;

}
