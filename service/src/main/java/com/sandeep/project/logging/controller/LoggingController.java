package com.sandeep.project.logging.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.project.logging.beans.AbstractLogBeanFactory;
import com.sandeep.project.logging.dto.AbstractLog;
import com.sandeep.project.logging.handler.AbstractLogTypeHandler;
import com.sandeep.project.logging.handler.LogTypeHandlerFactory;

@RestController
@RequestMapping(value = "/log/{serviceIdentifier}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingController {

	@Resource
	private LogTypeHandlerFactory logTypeHandlerFactory;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String log(@PathVariable("serviceIdentifier") String serviceIdentifier, @RequestBody AbstractLog log) {
		log.setServiceIdentifier(serviceIdentifier);
		return logTypeHandlerFactory.get(log.getLogType() + AbstractLogTypeHandler.BEAN_SUFFIX).handle(log).toString();
	}

	@RequestMapping(method = RequestMethod.GET, params = "logType")
	public @ResponseBody List<AbstractLogBeanFactory> findByLogType(@PathVariable("serviceIdentifier") String serviceIdentifier, @RequestParam("logType") String logType) {
		System.out.println("in get method");
		return logTypeHandlerFactory.get(logType + AbstractLogTypeHandler.BEAN_SUFFIX).findLogs(logType);
	}

}
