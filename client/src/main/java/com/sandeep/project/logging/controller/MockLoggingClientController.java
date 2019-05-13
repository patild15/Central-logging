package com.sandeep.project.logging.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.project.logging.dto.ChangePasswordLog;
import com.sandeep.project.logging.dto.ClientRequest;
import com.sandeep.project.logging.dto.EmailLog;
import com.sandeep.project.logging.dto.EmailSentStatus;
import com.sandeep.project.logging.dto.ErrorLog;
import com.sandeep.project.logging.dto.LoginLog;
import com.sandeep.project.logging.dto.ServiceResponse;
import com.sandeep.project.logging.dto.builder.ChangePasswordLogBuilder;
import com.sandeep.project.logging.dto.builder.ClientRequestBuilder;
import com.sandeep.project.logging.dto.builder.EmailLogBuilder;
import com.sandeep.project.logging.dto.builder.ErrorLogBuilder;
import com.sandeep.project.logging.dto.builder.LoginLogBuilder;
import com.sandeep.project.logging.dto.builder.ServiceResponseBuilder;
import com.sandeep.project.logging.sender.LogSender;

@RestController
@RequestMapping(value = "/log/mock", method = RequestMethod.GET)
public class MockLoggingClientController {

	@Value("${service.identifier}")
	private String serviceIdentifier;

	@Resource
	private LogSender logSender;

	@Resource
	private HttpServletRequest request;

	@RequestMapping(value = "/login/{userId}/success", params = "emailId")
	public void mockloginSuccess(@PathVariable("userId") String userId, @RequestParam("emailId") String emailId) {
		LoginLog loginLog = LoginLogBuilder.newInstance().withServiceIdentifier(serviceIdentifier)
				.withClientIp(request.getRemoteAddr()).withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withUserId(userId).withEmail(emailId).withLoginTime(new Date()).withSuccess().build();
		logSender.send(loginLog);
	}

	@RequestMapping(value = "/login/{userId}/fail", params = { "emailId", "errorMessage" })
	public void mockloginFail(@PathVariable("userId") String userId, @RequestParam("emailId") String emailId,
			@RequestParam("errorMessage") String errorMessage) {
		LoginLog loginLog = LoginLogBuilder.newInstance().withServiceIdentifier(serviceIdentifier)
				.withClientIp(request.getRemoteAddr()).withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withUserId(userId).withEmail(emailId).withLoginTime(new Date()).withError()
				.withErrorMessage(errorMessage).build();
		logSender.send(loginLog);
	}

	@RequestMapping(value = "/changepassword/{userId}/success", params = "emailId")
	public void mockChangePasswordSuccess(@PathVariable("userId") String userId,
			@RequestParam("emailId") String emailId) {
		ChangePasswordLog changePasswordLog = ChangePasswordLogBuilder.newInstance()
				.withServiceIdentifier(serviceIdentifier).withClientIp(request.getRemoteAddr())
				.withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withUserId(userId).withEmail(emailId).withChangeTime(new Date()).withSuccess().build();
		logSender.send(changePasswordLog);
	}

	@RequestMapping(value = "/changepassword/{userId}/fail", params = { "emailId", "errorMessage" })
	public void mockChangePasswordFail(@PathVariable("userId") String userId, @RequestParam("emailId") String emailId,
			@RequestParam("errorMessage") String errorMessage) {
		ChangePasswordLog changePasswordLog = ChangePasswordLogBuilder.newInstance()
				.withServiceIdentifier(serviceIdentifier).withClientIp(request.getRemoteAddr())
				.withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withUserId(userId).withEmail(emailId).withChangeTime(new Date()).withError()
				.withErrorMessage(errorMessage).build();
		logSender.send(changePasswordLog);
	}

	@RequestMapping(value = "/email/{userId}/success", params = { "fromEmail", "toEmail", "subject" })
	public void mockEmailSent(@PathVariable("userId") String userId, @RequestParam("fromEmail") String fromEmail,
			@RequestParam("toEmail") String toEmail, @RequestParam("subject") String subject) {
		EmailLog emailLog = EmailLogBuilder.newInstance().withServiceIdentifier(serviceIdentifier)
				.withClientIp(request.getRemoteAddr()).withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withUserId(userId).withFromEmail(fromEmail).withToEmail(toEmail).withSubject(subject)
				.withBody("Test Body " + UUID.randomUUID().toString()).withSentTime(new Date())
				.withStatus(EmailSentStatus.SENT).build();
		logSender.send(emailLog);
	}

	@RequestMapping(value = "/email/{userId}/fail", params = { "fromEmail", "toEmail", "subject" })
	public void mockEmailFail(@PathVariable("userId") String userId, @RequestParam("fromEmail") String fromEmail,
			@RequestParam("toEmail") String toEmail, @RequestParam("subject") String subject) {
		EmailLog emailLog = EmailLogBuilder.newInstance().withServiceIdentifier(serviceIdentifier)
				.withClientIp(request.getRemoteAddr()).withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withUserId(userId).withFromEmail(fromEmail).withToEmail(toEmail).withSubject(subject)
				.withBody("Test Body " + UUID.randomUUID().toString()).withSentTime(new Date())
				.withStatus(EmailSentStatus.FAILED).build();
		logSender.send(emailLog);
	}

	@RequestMapping(value = "/error", params = { "errorCode", "errorMessage" })
	public void mockError(@RequestParam("errorCode") String errorCode,
			@RequestParam("errorMessage") String errorMessage) {
		ErrorLog errorLog = ErrorLogBuilder.newInstance().withServiceIdentifier(serviceIdentifier)
				.withClientIp(request.getRemoteAddr()).withClientUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
				.withClientRequest(prepareClientRequest()).withServiceResponse(prepareServiceResponse())
				.withErrorCode(errorCode).withErrorMessage(errorMessage).build();
		logSender.send(errorLog);
	}

	private ClientRequest prepareClientRequest() {
		Map<String, String> headers = prepareHeadersMap();
		Map<String, List<String>> parameters = prepareParametersMap();
		Map<String, String> cookiesMap = prepareCookiesMap();
		return ClientRequestBuilder.newInstance().withUri(request.getRequestURI()).withHttpMethod(HttpMethod.GET.name())
				.withHeaders(headers).withParams(parameters).withCookies(cookiesMap).withBody(null).build();
	}

	private Map<String, String> prepareCookiesMap() {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return Collections.emptyMap();
		}
		Map<String, String> cookiesMap = Arrays.stream(cookies)
				.collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
		return cookiesMap;
	}

	private Map<String, List<String>> prepareParametersMap() {
		Map<String, List<String>> parameters = new HashMap<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			String[] parameterValues = request.getParameterValues(nextElement);
			parameters.put(nextElement, Arrays.asList(parameterValues));
		}
		return parameters;
	}

	private Map<String, String> prepareHeadersMap() {
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, String> headers = new HashMap<>();
		while (headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			headers.put(nextElement, request.getHeader(nextElement));
		}
		return headers;
	}

	private ServiceResponse prepareServiceResponse() {
		ServiceResponse serviceResponse = ServiceResponseBuilder.newInstance().withHttpStatus(HttpStatus.OK.value())
				.withHeaders(null).withCookies(null).withBody(null).build();
		return serviceResponse;
	}

}
