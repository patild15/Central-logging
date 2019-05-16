package com.sandeep.project.logging.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.beans.ErrorLogBean;
import com.sandeep.project.logging.crudRepository.ErrorLogRepository;
import com.sandeep.project.logging.dto.ErrorLog;

@Component(ErrorLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class ErrorLogHandler implements AbstractLogTypeHandler<ErrorLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordLogHandler.class);
	
	@Resource
	ErrorLogRepository logRepo;

	ErrorLogBean errLogBean;
	@Override
	public void handle(ErrorLog log) {
		LOGGER.info("Received Error Log " + log);
		errLogBean = new ErrorLogBean(log.getErrorCode(), log.getErrorMessage());
		logRepo.save(errLogBean);
		System.out.println(" Error Log recieved " + log.toString());
	}

}
