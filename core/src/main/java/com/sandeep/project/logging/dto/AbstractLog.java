package com.sandeep.project.logging.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "logType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ErrorLog.class, name = ErrorLog.LOG_TYPE),
		@JsonSubTypes.Type(value = LoginLog.class, name = LoginLog.LOG_TYPE),
		@JsonSubTypes.Type(value = ChangePasswordLog.class, name = ChangePasswordLog.LOG_TYPE),
		@JsonSubTypes.Type(value = EmailLog.class, name = EmailLog.LOG_TYPE), })
public abstract class AbstractLog {

	private String serviceIdentifier;

	private String clientIp;

	private String clientUserAgent;

	private ClientRequest clientRequest;

	private ServiceResponse serviceResponse;

	public abstract String getLogType();

	public String getServiceIdentifier() {
		return serviceIdentifier;
	}

	public void setServiceIdentifier(String serviceIdentifier) {
		this.serviceIdentifier = serviceIdentifier;
	}

	public ClientRequest getClientRequest() {
		return clientRequest;
	}

	public void setClientRequest(ClientRequest clientRequest) {
		this.clientRequest = clientRequest;
	}

	public ServiceResponse getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(ServiceResponse serviceResponse) {
		this.serviceResponse = serviceResponse;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getClientUserAgent() {
		return clientUserAgent;
	}

	public void setClientUserAgent(String clientUserAgent) {
		this.clientUserAgent = clientUserAgent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractLog [serviceIdentifier=").append(serviceIdentifier).append(", clientIp=")
				.append(clientIp).append(", clientUserAgent=").append(clientUserAgent).append(", clientRequest=")
				.append(clientRequest).append(", serviceResponse=").append(serviceResponse).append("]");
		return builder.toString();
	}

}
