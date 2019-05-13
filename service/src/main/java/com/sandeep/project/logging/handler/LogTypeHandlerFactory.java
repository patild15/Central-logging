package com.sandeep.project.logging.handler;

import com.sandeep.project.logging.dto.AbstractLog;

public interface LogTypeHandlerFactory {

	AbstractLogTypeHandler<AbstractLog> get(String type);

}
