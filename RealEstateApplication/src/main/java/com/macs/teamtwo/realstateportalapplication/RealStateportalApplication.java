package com.macs.teamtwo.realstateportalapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.macs.teamtwo.realstateportalapplication", "com.macs.teamtwo.realstateportalapplication.controller","com.macs.teamtwo.realstateportalapplication.repository","com.macs.teamtwo.realstateportalapplication.service","com.macs.teamtwo.realstateportalapplication.domain"})
public class RealStateportalApplication extends SpringBootServletInitializer {
	

	public static void main(String[] args) {
		SpringApplication.run(RealStateportalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RealStateportalApplication.class);
	}

	

}

