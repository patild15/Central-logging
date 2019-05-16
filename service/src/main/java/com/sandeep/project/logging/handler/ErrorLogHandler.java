package com.sandeep.project.logging.handler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.beans.AbstractLogBeanFactory;
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
	public Object handle(ErrorLog log) {
		LOGGER.info("Received Error Log " + log);
		errLogBean = new ErrorLogBean(log.getErrorCode(), log.getErrorMessage());
		logRepo.save(errLogBean);
		return (" Error Log recieved " + log.toString());
	}
	@Override
	public List<AbstractLogBeanFactory> findLogs(String logType) {
		// TODO Auto-generated method stub
		return StreamSupport.stream(logRepo.findAll().spliterator(), false) .collect(Collectors.toList());
	}

}
