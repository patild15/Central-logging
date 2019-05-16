package com.sandeep.project.logging.beans;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="ErrorLog")
public class ErrorLogBean implements AbstractLogBeanFactory {
	
	@Id
	@GeneratedValue
	private Long id;

	private final String logType = "ERROR";

	@NotNull
	private String errorCode;
	
	@NotNull
	private String errorMessage;
	
	@Column(name="createdAt",nullable=false,columnDefinition="TimeStamp default Current_Time")
	private Time createdAt;
	public ErrorLogBean() {}
	public ErrorLogBean(String errorCode, String errorMessage) {
		this.setErrorCode(errorCode);
		this.setErrorMessage(errorMessage);
		this.createdAt = new Time(System.currentTimeMillis());
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getLogType() {
		return logType;
	}
}
