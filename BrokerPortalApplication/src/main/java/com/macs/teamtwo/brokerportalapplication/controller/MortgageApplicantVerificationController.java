package com.macs.teamtwo.brokerportalapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;



@RestController
public class MortgageApplicantVerificationController {

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	// Verify the Applicant application Number
	@GetMapping(value = "/morgageaaplicant/{applicantID}")
	public MortgageApplicant showLoginPage(@PathVariable int applicantID) {
		return mortgageApplicantService.getApplicantDetails(applicantID);
		
	}

	@GetMapping(value = "/morgageaaplicantStatus/{applicantID}")
	public MortgageApplicant UpdateBrokerStatus(@PathVariable int applicantID) {
		return mortgageApplicantService.UpdateMortgageApplicantStatus(applicantID);
		
	}
}
