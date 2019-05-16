package com.sandeep.project.logging.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sandeep.project.logging.beans.AbstractLogBeanFactory;
import com.sandeep.project.logging.beans.EmailLogBean;
import com.sandeep.project.logging.crudRepository.EmailLogRepository;
import com.sandeep.project.logging.dto.EmailLog;

@Component(EmailLog.LOG_TYPE + AbstractLogTypeHandler.BEAN_SUFFIX)
public class EmailLogHandler implements AbstractLogTypeHandler<EmailLog> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailLogHandler.class);
	
	@Resource
	EmailLogRepository logRepo;
	EmailLogBean logBean;

	@Override
	public Object handle(EmailLog log) {
		LOGGER.info("Received Email Log " + log);
		System.out.println("Received Email Log " + log);
		logBean = new EmailLogBean(log.getUserId(),log.getFromEmail(),log.getToEmail(),log.getStatus().toString());
		return ("Received Email Log " + log.toString());
		
	}

	@Override
	public List<AbstractLogBeanFactory> findLogs(String logType) {
		// TODO Auto-generated method stub
		return null;
	}

}
