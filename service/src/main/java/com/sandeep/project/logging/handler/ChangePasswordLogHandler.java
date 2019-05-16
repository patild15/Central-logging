package com.sandeep.project.logging.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.beans.AbstractLogBeanFactory;
import com.sandeep.project.logging.dto.ChangePasswordLog;

@Component(ChangePasswordLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class ChangePasswordLogHandler implements AbstractLogTypeHandler<ChangePasswordLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordLogHandler.class);

	@Override
	public Object handle(ChangePasswordLog log) {
		LOGGER.info("Received Change Password Log " + log);
		return ("Received Change Password Log " + log.toString());
	}

	@Override
	public List<AbstractLogBeanFactory> findLogs(String logType) {
		// TODO Auto-generated method stub
		return null;
	}

}
