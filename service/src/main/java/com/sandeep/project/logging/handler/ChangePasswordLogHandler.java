package com.sandeep.project.logging.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.dto.ChangePasswordLog;

@Component(ChangePasswordLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class ChangePasswordLogHandler implements AbstractLogTypeHandler<ChangePasswordLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordLogHandler.class);

	@Override
	public void handle(ChangePasswordLog log) {
		LOGGER.info("Received Change Password Log " + log);
	}

}
