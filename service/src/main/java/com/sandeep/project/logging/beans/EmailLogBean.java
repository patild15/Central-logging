package com.sandeep.project.logging.beans;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="emailLog")
public class EmailLogBean implements AbstractLogBeanFactory{

	@Id
	@GeneratedValue
	Long id;

	@Column(name="createdAt",nullable=false,columnDefinition="TimeStamp default Current_Time")
	private Time createdAt;

	private String userId;

	private String fromEmail;

	private String toEmail;

	private String status;
	
	public EmailLogBean(String userId, String fromEmail, String toEmail, String status) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.fromEmail=fromEmail;
		this.toEmail=toEmail;
		this.status=status;
		this.createdAt = new Time(System.currentTimeMillis());
	}

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
