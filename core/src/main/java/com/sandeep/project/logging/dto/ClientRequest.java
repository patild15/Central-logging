package com.sandeep.project.logging.dto;

import java.util.List;
import java.util.Map;

public class ClientRequest {

	private String uri;

	private String httpMethod;

	private Map<String, String> headers;

	private Map<String, List<String>> params;

	private Map<String, String> cookies;

	private String body;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, List<String>> getParams() {
		return params;
	}

	public void setParams(Map<String, List<String>> params) {
		this.params = params;
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
		builder.append("ClientRequest [uri=").append(uri).append(", httpMethod=").append(httpMethod)
				.append(", headers=").append(headers).append(", params=").append(params).append(", cookies=")
				.append(cookies).append(", body=").append(body).append("]");
		return builder.toString();
	}

}
