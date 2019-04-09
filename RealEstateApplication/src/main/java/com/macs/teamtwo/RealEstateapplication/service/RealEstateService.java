package com.macs.teamtwo.RealEstateapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.RealEstateapplication.domain.RealEstate;
import com.macs.teamtwo.RealEstateapplication.domain.MortgageApplicant;
import com.macs.teamtwo.RealEstateapplication.repository.RealEstateRepository;

// employee service class
@Service
public class RealEstateService {
	
	//static final String URL_EMPLOYEE = "http://localhost:8086/morgageaaplicant/";
	
	String BrokerPort = Config.getProperty("BrokerPort");
	String BrokerIp = Config.getProperty("BrokerIp");
	
	String URL_EMPLOYEE ="http://"+BrokerIp+":"+BrokerPort+"/morgageaaplicant/";	
	
	RealEstateService()
	{
		
	}
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	// get employee by email id and password
	public RealEstate getEmployeeByEmailAndPassword(String email,String password) {
		RealEstate realEstate=realEstateRepository.getEmployeeByEmailAndPassword(email, password);
		return realEstate;
	}
	
	// get employee by email id and password
		public Boolean getEmployeeByApplicationNumber(String applicationNumber,String link) {
			RestTemplate restTemplate = new RestTemplate();
	        // Send request with GET method and default Headers.
	        MortgageApplicant applicant = restTemplate.getForObject(link+applicationNumber, MortgageApplicant.class);
	       
	     //   System.out.println("URL_EMPLOYEE: " +   URL_EMPLOYEE);
	        
	        if (applicant != null) {
	                System.out.println("RealEstate: " + applicant.getFirstName() + " - " + applicant.getLastName());
	                String URL_BrokerUpdate ="http://"+BrokerIp+":"+BrokerPort+"/morgageaaplicantStatus/";
	               restTemplate.getForObject(URL_BrokerUpdate+applicationNumber, MortgageApplicant.class);
	                return true;
	        }
			return false;
		}
}
