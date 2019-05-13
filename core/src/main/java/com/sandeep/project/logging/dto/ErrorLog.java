package com.sandeep.project.logging.dto;

public class ErrorLog extends AbstractLog {

	public static final String LOG_TYPE = "ERROR";

	private String errorCode;

	private String errorMessage;

	@Override
	public String getLogType() {
		return LOG_TYPE;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorLog [errorCode=").append(errorCode).append(", errorMessage=").append(errorMessage)
				.append(", abstractlog=").append(super.toString()).append("]");
		return builder.toString();
	}

}
