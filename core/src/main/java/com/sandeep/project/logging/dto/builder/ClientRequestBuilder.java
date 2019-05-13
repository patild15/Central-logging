package com.sandeep.project.logging.dto.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandeep.project.logging.dto.ClientRequest;

public class ClientRequestBuilder {

	private final ClientRequest clientRequest;

	private ClientRequestBuilder() {
		clientRequest = new ClientRequest();
	}

	public static WithUriBuilder newInstance() {
		return new ClientRequestBuilder().new Builder();
	}

	private class Builder implements WithUriBuilder, WithHttpMethodBuilder, WithHeadersBuilder, WithHeaderBuilder,
			WithParamsBuilder, WithParamBuilder, WithCookiesBuilder, WithCookieBuilder, FinalBuilder {

		@Override
		public FinalBuilder withBody(String body) {
			clientRequest.setBody(body);
			return this;
		}

		@Override
		public WithHeadersBuilder withHttpMethod(String httpMethod) {
			clientRequest.setHttpMethod(httpMethod);
			return this;
		}

		@Override
		public WithHttpMethodBuilder withUri(String uri) {
			clientRequest.setUri(uri);
			return this;
		}

		@Override
		public ClientRequest build() {
			return clientRequest;
		}

		@Override
		public WithCookiesBuilder withParams(Map<String, List<String>> params) {
			Map<String, List<String>> toBeSetParams = null;
			if (params != null) {
				toBeSetParams = new HashMap<>(params);
			}
			clientRequest.setParams(toBeSetParams);
			return this;
		}

		@Override
		public WithParamBuilder withParam(String param, List<String> values) {
			if (clientRequest.getParams() == null) {
				clientRequest.setParams(new HashMap<>());
			}
			clientRequest.getParams().put(param, values);
			return this;
		}

		@Override
		public WithBodyBuilder withCookies(Map<String, String> cookies) {
			Map<String, String> toBeSetCookies = null;
			if (cookies != null) {
				toBeSetCookies = new HashMap<>(cookies);
			}
			clientRequest.setCookies(toBeSetCookies);
			return this;
		}

		@Override
		public WithCookieBuilder withCookie(String param, String value) {
			if (clientRequest.getCookies() == null) {
				clientRequest.setCookies(new HashMap<>());
			}
			clientRequest.getCookies().put(param, value);
			return this;
		}

		@Override
		public WithParamsBuilder withHeaders(Map<String, String> headers) {
			Map<String, String> toBeSetHeaders = null;
			if (headers != null) {
				toBeSetHeaders = new HashMap<>(headers);
			}
			clientRequest.setHeaders(toBeSetHeaders);
			return this;
		}

		@Override
		public WithHeaderBuilder withHeader(String header, String value) {
			if (clientRequest.getHeaders() == null) {
				clientRequest.setHeaders(new HashMap<>());
			}
			clientRequest.getHeaders().put(header, value);
			return this;
		}

	}

	public interface WithUriBuilder {

		WithHttpMethodBuilder withUri(String uri);

	}

	public interface WithHttpMethodBuilder {

		WithHeadersBuilder withHttpMethod(String httpMethod);

	}

	public interface WithHeadersBuilder {

		WithParamsBuilder withHeaders(Map<String, String> headers);

		WithHeaderBuilder withHeader(String header, String value);

	}

	public interface WithHeaderBuilder extends WithParamsBuilder {

		WithHeaderBuilder withHeader(String header, String value);

	}

	public interface WithParamsBuilder {

		WithCookiesBuilder withParams(Map<String, List<String>> params);

		WithParamBuilder withParam(String param, List<String> values);

	}

	public interface WithParamBuilder extends WithCookiesBuilder {

		WithParamBuilder withParam(String param, List<String> values);

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

		ClientRequest build();

	}

}
