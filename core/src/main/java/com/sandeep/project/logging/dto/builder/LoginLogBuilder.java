package com.sandeep.project.logging.dto.builder;

import java.util.Date;

import com.sandeep.project.logging.dto.ClientRequest;
import com.sandeep.project.logging.dto.LoginLog;
import com.sandeep.project.logging.dto.LoginStatus;
import com.sandeep.project.logging.dto.ServiceResponse;

public class LoginLogBuilder {

	private final LoginLog loginLog;

	private LoginLogBuilder() {
		loginLog = new LoginLog();
	}

	public static WithServiceIdentifierBuilder newInstance() {
		return new LoginLogBuilder().new Builder();
	}

	private class Builder implements FinalBuilder, WithErrorMessageBuilder, WithLoginStatusBuilder,
			WithLoginTimeBuilder, WithEmailBuilder, WithUserIdBuilder, WithServiceResponseBuilder,
			WithClientRequestBuilder, WithClientUserAgentBuilder, WithClientIpBuilder, WithServiceIdentifierBuilder {

		@Override
		public WithClientIpBuilder withServiceIdentifier(String serviceIdentifier) {
			loginLog.setServiceIdentifier(serviceIdentifier);
			return this;
		}

		@Override
		public WithClientUserAgentBuilder withClientIp(String clientIp) {
			loginLog.setClientIp(clientIp);
			return this;
		}

		@Override
		public WithClientRequestBuilder withClientUserAgent(String clientUserAgent) {
			loginLog.setClientUserAgent(clientUserAgent);
			return this;
		}

		@Override
		public WithServiceResponseBuilder withClientRequest(ClientRequest clientRequest) {
			loginLog.setClientRequest(clientRequest);
			return this;
		}

		@Override
		public WithUserIdBuilder withServiceResponse(ServiceResponse serviceResponse) {
			loginLog.setServiceResponse(serviceResponse);
			return this;
		}

		@Override
		public WithEmailBuilder withUserId(String userId) {
			loginLog.setUserId(userId);
			return this;
		}

		@Override
		public WithLoginTimeBuilder withEmail(String email) {
			loginLog.setEmail(email);
			return this;
		}

		@Override
		public WithLoginStatusBuilder withLoginTime(Date loginTime) {
			loginLog.setLoginTime(loginTime);
			return this;
		}

		@Override
		public FinalBuilder withSuccess() {
			loginLog.setStatus(LoginStatus.SUCCESS);
			return this;
		}

		@Override
		public WithErrorMessageBuilder withError() {
			loginLog.setStatus(LoginStatus.ERROR);
			return this;
		}

		@Override
		public FinalBuilder withErrorMessage(String errorMessage) {
			loginLog.setErrorMessage(errorMessage);
			return this;
		}

		@Override
		public LoginLog build() {
			return loginLog;
		}

	}

	public interface FinalBuilder {

		LoginLog build();

	}

	public interface WithErrorMessageBuilder {

		FinalBuilder withErrorMessage(String errorMessage);

	}

	public interface WithLoginStatusBuilder {

		FinalBuilder withSuccess();

		WithErrorMessageBuilder withError();

	}

	public interface WithLoginTimeBuilder {

		WithLoginStatusBuilder withLoginTime(Date loginTime);

	}

	public interface WithEmailBuilder {

		WithLoginTimeBuilder withEmail(String email);

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
