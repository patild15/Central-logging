package com.sandeep.project.logging.dto;

import java.util.Map;

public class ServiceResponse {

	private int httpStatus;

	private Map<String, String> headers;

	private Map<String, String> cookies;

	private String body;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceResponse [httpStatus=").append(httpStatus).append(", headers=").append(headers)
				.append(", cookies=").append(cookies).append(", body=").append(body).append("]");
		return builder.toString();
	}

}
