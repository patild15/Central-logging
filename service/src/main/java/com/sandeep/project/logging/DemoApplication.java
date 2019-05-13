package com.sandeep.project.logging;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sandeep.project.logging.handler.LogTypeHandlerFactory;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ServiceLocatorFactoryBean logTypeHandlerFactory() {
		ServiceLocatorFactoryBean logTypeHandlerFactory = new ServiceLocatorFactoryBean();
		logTypeHandlerFactory.setServiceLocatorInterface(LogTypeHandlerFactory.class);
		return logTypeHandlerFactory;
	}

}
