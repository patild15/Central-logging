package com.sandeep.project.logging.dto.builder;

import java.util.Date;

import com.sandeep.project.logging.dto.ClientRequest;
import com.sandeep.project.logging.dto.EmailLog;
import com.sandeep.project.logging.dto.EmailSentStatus;
import com.sandeep.project.logging.dto.ServiceResponse;

public class EmailLogBuilder {

	private final EmailLog emailLog;

	private EmailLogBuilder() {
		emailLog = new EmailLog();
	}

	public static WithServiceIdentifierBuilder newInstance() {
		return new EmailLogBuilder().new Builder();
	}

	private class Builder implements FinalBuilder, WithStatusBuilder, WithSentTimeBuilder, WithBodyBuilder,
			WithSubjectBuilder, WithToEmailBuilder, WithFromEmailBuilder, WithUserIdBuilder, WithServiceResponseBuilder,
			WithClientRequestBuilder, WithClientUserAgentBuilder, WithClientIpBuilder, WithServiceIdentifierBuilder {

		@Override
		public WithClientIpBuilder withServiceIdentifier(String serviceIdentifier) {
			emailLog.setServiceIdentifier(serviceIdentifier);
			return this;
		}

		@Override
		public WithClientUserAgentBuilder withClientIp(String clientIp) {
			emailLog.setClientIp(clientIp);
			return this;
		}

		@Override
		public WithClientRequestBuilder withClientUserAgent(String clientUserAgent) {
			emailLog.setClientUserAgent(clientUserAgent);
			return this;
		}

		@Override
		public WithServiceResponseBuilder withClientRequest(ClientRequest clientRequest) {
			emailLog.setClientRequest(clientRequest);
			return this;
		}

		@Override
		public WithUserIdBuilder withServiceResponse(ServiceResponse serviceResponse) {
			emailLog.setServiceResponse(serviceResponse);
			return this;
		}

		@Override
		public WithFromEmailBuilder withUserId(String userId) {
			emailLog.setUserId(userId);
			return this;
		}

		@Override
		public WithToEmailBuilder withFromEmail(String fromEmail) {
			emailLog.setFromEmail(fromEmail);
			return this;
		}

		@Override
		public WithSubjectBuilder withToEmail(String toEmail) {
			emailLog.setToEmail(toEmail);
			return this;
		}

		@Override
		public WithBodyBuilder withSubject(String subject) {
			emailLog.setSubject(subject);
			return this;
		}

		@Override
		public WithSentTimeBuilder withBody(String body) {
			emailLog.setBody(body);
			return this;
		}

		@Override
		public WithStatusBuilder withSentTime(Date sentTime) {
			emailLog.setSentTime(sentTime);
			return this;
		}

		@Override
		public FinalBuilder withStatus(EmailSentStatus status) {
			emailLog.setStatus(status);
			return this;
		}

		@Override
		public EmailLog build() {
			return emailLog;
		}

	}

	public interface FinalBuilder {

		EmailLog build();

	}

	public interface WithStatusBuilder {

		FinalBuilder withStatus(EmailSentStatus status);

	}

	public interface WithSentTimeBuilder {

		WithStatusBuilder withSentTime(Date sentTime);

	}

	public interface WithBodyBuilder {

		WithSentTimeBuilder withBody(String body);

	}

	public interface WithSubjectBuilder {

		WithBodyBuilder withSubject(String subject);

	}

	public interface WithToEmailBuilder {

		WithSubjectBuilder withToEmail(String toEmail);

	}

	public interface WithFromEmailBuilder {

		WithToEmailBuilder withFromEmail(String fromEmail);

	}

	public interface WithUserIdBuilder {

		WithFromEmailBuilder withUserId(String userId);

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
