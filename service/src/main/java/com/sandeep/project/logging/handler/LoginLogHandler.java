package com.sandeep.project.logging.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.dto.LoginLog;

@Component(LoginLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class LoginLogHandler implements AbstractLogTypeHandler<LoginLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogHandler.class);

	@Override
	public void handle(LoginLog log) {
		LOGGER.info("Received Login Log " + log);
	}

}
