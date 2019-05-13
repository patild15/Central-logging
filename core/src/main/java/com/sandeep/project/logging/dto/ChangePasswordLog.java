package com.sandeep.project.logging.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChangePasswordLog extends AbstractLog {

	public static final String LOG_TYPE = "CHANGE_PASSWORD";

	private String userId;

	private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'hh:mm:ss.ssssssZ")
	private Date changeTime;

	private ChangePasswordStatus status;

	private String errorMessage;

	@Override
	public String getLogType() {
		return LOG_TYPE;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public ChangePasswordStatus getStatus() {
		return status;
	}

	public void setStatus(ChangePasswordStatus status) {
		this.status = status;
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
		builder.append("ChangePasswordLog [userId=").append(userId).append(", email=").append(email)
				.append(", changeTime=").append(changeTime).append(", status=").append(status).append(", errorMessage=")
				.append(errorMessage).append(", abstractlog=").append(super.toString()).append("]");
		return builder.toString();
	}

}
