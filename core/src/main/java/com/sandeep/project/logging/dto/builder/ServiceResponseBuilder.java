package com.sandeep.project.logging.dto.builder;

import java.util.HashMap;
import java.util.Map;

import com.sandeep.project.logging.dto.ServiceResponse;

public class ServiceResponseBuilder {

	private final ServiceResponse serviceResponse;

	private ServiceResponseBuilder() {
		serviceResponse = new ServiceResponse();
	}

	public static WithHttpStatusBuilder newInstance() {
		return new ServiceResponseBuilder().new Builder();
	}

	private class Builder
			implements WithHttpStatusBuilder, WithHeadersBuilder, WithHeaderBuilder, WithCookieBuilder, FinalBuilder {

		@Override
		public FinalBuilder withBody(String body) {
			serviceResponse.setBody(body);
			return this;
		}

		@Override
		public ServiceResponse build() {
			return serviceResponse;
		}

		@Override
		public WithBodyBuilder withCookies(Map<String, String> cookies) {
			Map<String, String> toBeSetCookies = null;
			if (cookies != null) {
				toBeSetCookies = new HashMap<>(cookies);
			}
			serviceResponse.setCookies(toBeSetCookies);
			return this;
		}

		@Override
		public WithCookieBuilder withCookie(String param, String value) {
			if (serviceResponse.getCookies() == null) {
				serviceResponse.setCookies(new HashMap<>());
			}
			serviceResponse.getCookies().put(param, value);
			return this;
		}

		@Override
		public WithCookiesBuilder withHeaders(Map<String, String> headers) {
			Map<String, String> toBeSetHeaders = null;
			if (headers != null) {
				toBeSetHeaders = new HashMap<>(headers);
			}
			serviceResponse.setHeaders(toBeSetHeaders);
			return this;
		}

		@Override
		public WithHeaderBuilder withHeader(String header, String value) {
			if (serviceResponse.getHeaders() == null) {
				serviceResponse.setHeaders(new HashMap<>());
			}
			serviceResponse.getHeaders().put(header, value);
			return this;
		}

		@Override
		public WithHeadersBuilder withHttpStatus(int httpStatus) {
			serviceResponse.setHttpStatus(httpStatus);
			return this;
		}

	}

	public interface WithHttpStatusBuilder {

		WithHeadersBuilder withHttpStatus(int httpStatus);

	}

	public interface WithHeadersBuilder {

		WithCookiesBuilder withHeaders(Map<String, String> headers);

		WithHeaderBuilder withHeader(String header, String value);

	}

	public interface WithHeaderBuilder extends WithCookiesBuilder {

		WithHeaderBuilder withHeader(String header, String value);

	}

	public interface WithCookiesBuilder {

		WithBodyBuilder withCookies(Map<String, String> cookies);

		WithCookieBuilder withCookie(String param, String value);

	}

	public interface WithCookieBuilder extends WithBodyBuilder {

		WithCookieBuilder withCookie(String param, String value);

	}

	public interface WithBodyBuilder {

		FinalBuilder withBody(String body);

	}

	public interface FinalBuilder {

		ServiceResponse build();

	}

}
