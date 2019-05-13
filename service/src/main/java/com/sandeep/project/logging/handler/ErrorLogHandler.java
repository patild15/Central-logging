package com.sandeep.project.logging.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.crudRepository.LoggerRepository;
import com.sandeep.project.logging.dto.ErrorLog;

@Component(ErrorLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class ErrorLogHandler implements AbstractLogTypeHandler<ErrorLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordLogHandler.class);
	
	@Resource
	LoggerRepository logRepo;

	@Override
	public void handle(ErrorLog log) {
		LOGGER.info("Received Error Log " + log);
		logRepo.save(log);
	}

}
