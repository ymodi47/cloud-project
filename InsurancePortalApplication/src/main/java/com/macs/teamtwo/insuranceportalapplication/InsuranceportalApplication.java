package com.macs.teamtwo.insuranceportalapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.insuranceportalapplication.controller", "com.macs.teamtwo.insuranceportalapplication.controller","com.macs.teamtwo.insuranceportalapplication.domain","com.macs.teamtwo.insuranceportalapplication.service","com.macs.teamtwo.insuranceportalapplication.service"})
public class InsuranceportalApplication extends SpringBootServletInitializer {
	
	static Logger logger = LoggerFactory.getLogger(InsuranceportalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InsuranceportalApplication.class, args);
		logger.trace("Insurance Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InsuranceportalApplication.class);
	}

	

}

