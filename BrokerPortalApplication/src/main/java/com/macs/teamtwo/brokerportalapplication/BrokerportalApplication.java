package com.macs.teamtwo.brokerportalapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.brokerportalapplication", "com.macs.teamtwo.brokerportalapplication.controller","com.macs.teamtwo.brokerportalapplication.repository","com.macs.teamtwo.brokerportalapplication.service","com.macs.teamtwo.brokerportalapplication.domain"})
public class BrokerportalApplication extends SpringBootServletInitializer {
	
	static Logger logger = LoggerFactory.getLogger(BrokerportalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BrokerportalApplication.class, args);
		logger.trace("brokerportal Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BrokerportalApplication.class);
	}

	

}

