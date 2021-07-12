package com.tradeledger.cards.models;

public class ErrorResposeEntity {
	
	
	private String errorCode;
	private String errorDescription;
	
	public ErrorResposeEntity(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
