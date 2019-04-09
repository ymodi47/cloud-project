package com.macs.teamtwo.RealEstateapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.RealEstateapplication", "com.macs.teamtwo.RealEstateapplication.controller","com.macs.teamtwo.RealEstateapplication.repository","com.macs.teamtwo.RealEstateapplication.service","com.macs.teamtwo.RealEstateapplication.domain"})
public class RealEstateApplication extends SpringBootServletInitializer {
	
	static Logger logger = LoggerFactory.getLogger(RealEstateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
		logger.trace("employerportal Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RealEstateApplication.class);
	}

	

}

