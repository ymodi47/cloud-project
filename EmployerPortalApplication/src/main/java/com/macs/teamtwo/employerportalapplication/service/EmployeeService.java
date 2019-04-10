package com.macs.teamtwo.employerportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.employerportalapplication.domain.Employee;
import com.macs.teamtwo.employerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.employerportalapplication.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {


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
		restTemplate.getForObject(link.trim()+ applicationNumber.trim(),String.class);
		System.out.println("returned sucessfully.");
		return true;
	}
}
