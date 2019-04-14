package com.macs.teamtwo.employerportalapplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.employerportalapplication", "com.macs.teamtwo.employerportalapplication.controller","com.macs.teamtwo.employerportalapplication.repository","com.macs.teamtwo.employerportalapplication.service","com.macs.teamtwo.employerportalapplication.domain"})
public class EmployerportalApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = Logger.getLogger(EmployerportalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployerportalApplication.class, args);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("employerportal Application has been started..");
		logger.trace("employerportal Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmployerportalApplication.class);
	}

	

}

