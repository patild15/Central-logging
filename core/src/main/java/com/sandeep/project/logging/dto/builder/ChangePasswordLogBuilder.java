package com.sandeep.project.logging.dto.builder;

import java.util.Date;

import com.sandeep.project.logging.dto.ChangePasswordLog;
import com.sandeep.project.logging.dto.ChangePasswordStatus;
import com.sandeep.project.logging.dto.ClientRequest;
import com.sandeep.project.logging.dto.ServiceResponse;

public class ChangePasswordLogBuilder {

	private final ChangePasswordLog changePasswordLog;

	private ChangePasswordLogBuilder() {
		changePasswordLog = new ChangePasswordLog();
	}

	public static WithServiceIdentifierBuilder newInstance() {
		return new ChangePasswordLogBuilder().new Builder();
	}

	private class Builder implements FinalBuilder, WithErrorMessageBuilder, WithStatusBuilder, WithChangeTimeBuilder,
			WithEmailBuilder, WithUserIdBuilder, WithServiceResponseBuilder, WithClientRequestBuilder,
			WithClientUserAgentBuilder, WithClientIpBuilder, WithServiceIdentifierBuilder {

		@Override
		public WithClientIpBuilder withServiceIdentifier(String serviceIdentifier) {
			changePasswordLog.setServiceIdentifier(serviceIdentifier);
			return this;
		}

		@Override
		public WithClientUserAgentBuilder withClientIp(String clientIp) {
			changePasswordLog.setClientIp(clientIp);
			return this;
		}

		@Override
		public WithClientRequestBuilder withClientUserAgent(String clientUserAgent) {
			changePasswordLog.setClientUserAgent(clientUserAgent);
			return this;
		}

		@Override
		public WithServiceResponseBuilder withClientRequest(ClientRequest clientRequest) {
			changePasswordLog.setClientRequest(clientRequest);
			return this;
		}

		@Override
		public WithUserIdBuilder withServiceResponse(ServiceResponse serviceResponse) {
			changePasswordLog.setServiceResponse(serviceResponse);
			return this;
		}

		@Override
		public WithEmailBuilder withUserId(String userId) {
			changePasswordLog.setUserId(userId);
			return this;
		}

		@Override
		public WithChangeTimeBuilder withEmail(String email) {
			changePasswordLog.setEmail(email);
			return this;
		}

		@Override
		public WithStatusBuilder withChangeTime(Date changeTime) {
			changePasswordLog.setChangeTime(changeTime);
			return this;
		}

		@Override
		public FinalBuilder withSuccess() {
			changePasswordLog.setStatus(ChangePasswordStatus.SUCCESS);
			return this;
		}

		@Override
		public WithErrorMessageBuilder withError() {
			changePasswordLog.setStatus(ChangePasswordStatus.ERROR);
			return this;
		}

		@Override
		public FinalBuilder withErrorMessage(String errorMessage) {
			changePasswordLog.setErrorMessage(errorMessage);
			return this;
		}

		@Override
		public ChangePasswordLog build() {
			return changePasswordLog;
		}

	}

	public interface FinalBuilder {

		ChangePasswordLog build();

	}

	public interface WithErrorMessageBuilder {

		FinalBuilder withErrorMessage(String errorMessage);

	}

	public interface WithStatusBuilder {

		FinalBuilder withSuccess();

		WithErrorMessageBuilder withError();

	}

	public interface WithChangeTimeBuilder {

		WithStatusBuilder withChangeTime(Date changeTime);

	}

	public interface WithEmailBuilder {

		WithChangeTimeBuilder withEmail(String email);

	}

	public interface WithUserIdBuilder {

		WithEmailBuilder withUserId(String userId);

	}

	public interface WithServiceResponseBuilder {

		WithUserIdBuilder withServiceResponse(ServiceResponse serviceResponse);

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
