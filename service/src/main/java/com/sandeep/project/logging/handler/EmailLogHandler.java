package com.sandeep.project.logging.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.dto.EmailLog;

@Component(EmailLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class EmailLogHandler implements AbstractLogTypeHandler<EmailLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailLogHandler.class);

	@Override
	public void handle(EmailLog log) {
		LOGGER.info("Received Email Log " + log);
	}

}
