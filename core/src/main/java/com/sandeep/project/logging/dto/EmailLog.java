package com.sandeep.project.logging.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmailLog extends AbstractLog {

	public static final String LOG_TYPE = "EMAIL";

	private String userId;

	private String fromEmail;

	private String toEmail;

	private String subject;

	private String body;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'hh:mm:ss.ssssssZ")
	private Date sentTime;

	private EmailSentStatus status;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public EmailSentStatus getStatus() {
		return status;
	}

	public void setStatus(EmailSentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailLog [userId=").append(userId).append(", fromEmail=").append(fromEmail).append(", toEmail=")
				.append(toEmail).append(", subject=").append(subject).append(", body=").append(body)
				.append(", sentTime=").append(sentTime).append(", status=").append(status).append(", abstractlog=")
				.append(super.toString()).append("]");
		return builder.toString();
	}

}
