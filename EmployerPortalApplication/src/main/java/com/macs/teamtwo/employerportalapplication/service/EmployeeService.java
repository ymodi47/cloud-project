package com.macs.teamtwo.employerportalapplication.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.employerportalapplication.domain.Employee;
import com.macs.teamtwo.employerportalapplication.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	EmployeeService() {

	}

	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		Employee employee = employeeRepository.getEmployeeByEmailAndPassword(email, password);
		return employee;
	}

	// get employee by email id and password
	public Boolean getEmployeeByApplicationNumber(String applicationNumber, String link) {
		RestTemplate restTemplate = new RestTemplate();
		logger.info("invoking MBR for Employee Verfication with details applicationNumber "+applicationNumber+" provided link : "+link);
		restTemplate.getForObject(link.trim()+ applicationNumber.trim(),String.class);
		logger.info("Successfully invoked MBR portal from Employee Portal for Applicant Verification.");
		return true;
	}
}
