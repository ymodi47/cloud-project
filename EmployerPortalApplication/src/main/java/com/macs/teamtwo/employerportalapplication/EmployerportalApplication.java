package com.macs.teamtwo.employerportalapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.employerportalapplication", "com.macs.teamtwo.employerportalapplication.controller","com.macs.teamtwo.employerportalapplication.repository","com.macs.teamtwo.employerportalapplication.service","com.macs.teamtwo.employerportalapplication.domain"})
public class EmployerportalApplication extends SpringBootServletInitializer {
	
	static Logger logger = LoggerFactory.getLogger(EmployerportalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployerportalApplication.class, args);
		logger.trace("employerportal Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmployerportalApplication.class);
	}

	

}

