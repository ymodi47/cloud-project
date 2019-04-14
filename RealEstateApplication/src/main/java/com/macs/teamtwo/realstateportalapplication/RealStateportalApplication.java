package com.macs.teamtwo.realstateportalapplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.realstateportalapplication", "com.macs.teamtwo.realstateportalapplication.controller","com.macs.teamtwo.realstateportalapplication.repository","com.macs.teamtwo.realstateportalapplication.service","com.macs.teamtwo.realstateportalapplication.domain"})
public class RealStateportalApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = Logger.getLogger(RealStateportalApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(RealStateportalApplication.class, args);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("RealStateportalApplication Application has been started..");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RealStateportalApplication.class);
	}

	

}

