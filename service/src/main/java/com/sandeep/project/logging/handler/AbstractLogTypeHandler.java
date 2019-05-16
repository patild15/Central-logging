package com.sandeep.project.logging.handler;

import java.util.List;

import com.sandeep.project.logging.beans.AbstractLogBeanFactory;
import com.sandeep.project.logging.dto.AbstractLog;

public interface AbstractLogTypeHandler<LOG_TYPE extends AbstractLog> {

	String BEAN_SUFFIX = "TypeHandler";
	
	Object handle(LOG_TYPE log);

	List<AbstractLogBeanFactory> findLogs(String logType);

}
