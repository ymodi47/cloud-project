package com.macs.teamtwo.insuranceportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.insuranceportalapplication.domain.Insurance;
import com.macs.teamtwo.insuranceportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.insuranceportalapplication.repository.InsuranceRepository;

// employee service class
@Service
public class InsuranceService {
	
	//static final String URL_EMPLOYEE = "http://localhost:8086/morgageaaplicant/";
	
	String BrokerPort = Config.getProperty("BrokerPort");
	String BrokerIp = Config.getProperty("BrokerIp");
	
	String URL_EMPLOYEE ="http://"+BrokerIp+":"+BrokerPort+"/morgageaaplicant/";	
	
	InsuranceService()
	{
		
	}
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	// get employee by email id and password
	public Insurance getEmployeeByEmailAndPassword(String email,String password) {
		Insurance insurance=insuranceRepository.getEmployeeByEmailAndPassword(email, password);
		return insurance;
	}
	
	// get employee by email id and password
		public Boolean getEmployeeByApplicationNumber(String applicationNumber,String link) {
			RestTemplate restTemplate = new RestTemplate();
	        // Send request with GET method and default Headers.
	        MortgageApplicant applicant = restTemplate.getForObject(link+applicationNumber, MortgageApplicant.class);
	       
	     //   System.out.println("URL_EMPLOYEE: " +   URL_EMPLOYEE);
	        
	        if (applicant != null) {
	                System.out.println("Insurance: " + applicant.getFirstName() + " - " + applicant.getLastName());
	                String URL_BrokerUpdate ="http://"+BrokerIp+":"+BrokerPort+"/morgageaaplicantStatus/";
	               restTemplate.getForObject(URL_BrokerUpdate+applicationNumber, MortgageApplicant.class);
	                return true;
	        }
			return false;
		}
}
