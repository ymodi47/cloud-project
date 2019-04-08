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
	@GetMapping(value = "/morgageaaplicant/{MortgageID}")
	public MortgageApplicant showLoginPage(@PathVariable int MortgageID) {
		return mortgageApplicantService.getApplicantByMortgageID(MortgageID);
		
	}

	@GetMapping(value = "/morgageaaplicantStatus/{MortgageID}")
	public MortgageApplicant UpdateBrokerStatus(@PathVariable int MortgageID) {
		return mortgageApplicantService.UpdateMortgageApplicant(MortgageID);
		
	}
}
