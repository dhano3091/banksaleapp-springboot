package com.mindtree.banksale.dto;

public class ErrorDTO {

	private String errorMessage;
	private String errorType;
	
	public ErrorDTO() {
		
	}

	public ErrorDTO(String errorMessage, String errorType) {
		super();
		this.errorMessage = errorMessage;
		this.errorType = errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	@Override
	public String toString() {
		return "ErrorDTO [errorMessage=" + errorMessage + ", errorType=" + errorType + "]";
	}
	
	
}
