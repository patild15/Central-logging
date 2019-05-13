package com.sandeep.project.logging.dto.builder;

import com.sandeep.project.logging.dto.ClientRequest;
import com.sandeep.project.logging.dto.ErrorLog;
import com.sandeep.project.logging.dto.ServiceResponse;

public class ErrorLogBuilder {

	private final ErrorLog errorLog;

	private ErrorLogBuilder() {
		this.errorLog = new ErrorLog();
	}

	public static WithServiceIdentifierBuilder newInstance() {
		return new ErrorLogBuilder().new Builder();
	}

	private class Builder
			implements FinalBuilder, WithErrorMessageBuilder, WithErrorCodeBuilder, WithServiceResponseBuilder,
			WithClientRequestBuilder, WithClientUserAgentBuilder, WithClientIpBuilder, WithServiceIdentifierBuilder {

		@Override
		public WithClientIpBuilder withServiceIdentifier(String serviceIdentifier) {
			errorLog.setServiceIdentifier(serviceIdentifier);
			return this;
		}

		@Override
		public WithClientUserAgentBuilder withClientIp(String clientIp) {
			errorLog.setClientIp(clientIp);
			return this;
		}

		@Override
		public WithClientRequestBuilder withClientUserAgent(String clientUserAgent) {
			errorLog.setClientUserAgent(clientUserAgent);
			return this;
		}

		@Override
		public WithServiceResponseBuilder withClientRequest(ClientRequest clientRequest) {
			errorLog.setClientRequest(clientRequest);
			return this;
		}

		@Override
		public WithErrorCodeBuilder withServiceResponse(ServiceResponse serviceResponse) {
			errorLog.setServiceResponse(serviceResponse);
			return this;
		}

		@Override
		public WithErrorMessageBuilder withErrorCode(String errorCode) {
			errorLog.setErrorCode(errorCode);
			return this;
		}

		@Override
		public FinalBuilder withErrorMessage(String errorMessage) {
			errorLog.setErrorMessage(errorMessage);
			return this;
		}

		@Override
		public ErrorLog build() {
			return errorLog;
		}

	}

	public interface FinalBuilder {

		ErrorLog build();

	}

	public interface WithErrorMessageBuilder {

		FinalBuilder withErrorMessage(String errorMessage);

	}

	public interface WithErrorCodeBuilder {

		WithErrorMessageBuilder withErrorCode(String errorCode);

	}

	public interface WithServiceResponseBuilder {

		WithErrorCodeBuilder withServiceResponse(ServiceResponse serviceResponse);

	}

	public interface WithClientRequestBuilder {

		WithServiceResponseBuilder withClientRequest(ClientRequest clientRequest);

	}

	public interface WithClientUserAgentBuilder {

		WithClientRequestBuilder withClientUserAgent(String clientUserAgent);

	}

	public interface WithClientIpBuilder {

		WithClientUserAgentBuilder withClientIp(String clientIp);

	}

	public interface WithServiceIdentifierBuilder {

		WithClientIpBuilder withServiceIdentifier(String serviceIdentifier);

	}

}
