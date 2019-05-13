package com.sandeep.project.logging.sender;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sandeep.project.logging.dto.AbstractLog;

@Component
public class LogSender {

	private static final String LOG_SERVICE_CLIENT_URI = "/log/";

	private static final Logger LOGGER = LoggerFactory.getLogger(LogSender.class);

	@Value("${log.service.url}")
	private String logServiceUrl;

	@Value("${service.identifier}")
	private String serviceIdentifier;

	@Resource
	private RestTemplate logServiceRestTemplate;

	private String logPostUrl;

	@PostConstruct
	public void init() {
		logPostUrl = logServiceUrl + LOG_SERVICE_CLIENT_URI + serviceIdentifier;
	}

	public void send(AbstractLog log) {
		LOGGER.info("Sending Log: {}", log);
		logServiceRestTemplate.postForLocation(logPostUrl, log);
	}

}
