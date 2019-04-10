package com.macs.teamtwo.brokerportalapplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.brokerportalapplication", "com.macs.teamtwo.brokerportalapplication.controller","com.macs.teamtwo.brokerportalapplication.repository","com.macs.teamtwo.brokerportalapplication.service","com.macs.teamtwo.brokerportalapplication.domain"})
public class BrokerportalApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = Logger.getLogger(BrokerportalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BrokerportalApplication.class, args);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("brokerportal Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BrokerportalApplication.class);
	}

	

}

