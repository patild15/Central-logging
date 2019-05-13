package com.sandeep.project.logging.handler;

import com.sandeep.project.logging.dto.AbstractLog;

public interface AbstractLogTypeHandler<LOG_TYPE extends AbstractLog> {

	String BEAN_SUFFIX = "TypeHandler";
	
	void handle(LOG_TYPE log);

}
