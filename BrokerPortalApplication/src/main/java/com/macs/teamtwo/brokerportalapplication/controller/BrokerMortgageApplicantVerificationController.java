package com.macs.teamtwo.brokerportalapplication.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;

@RestController
public class BrokerMortgageApplicantVerificationController {

	private static final Logger logger = Logger.getLogger(BrokerMortgageApplicantVerificationController.class);

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	// Verify the Applicant application Number
	@GetMapping(value = "/mortgageapplicant/{applicantID}")
	public MortgageApplicant getApplicationStatus(@PathVariable int applicantID) {
		MortgageApplicant mort = mortgageApplicantService.getApplicantDetails(applicantID);
		return null;

	}

	@GetMapping(value = "/mortgageapplicantstatus/{applicantID}")
	public MortgageApplicant UpdateBrokerStatus(@PathVariable int applicantID) {
		MortgageApplicant mort = mortgageApplicantService.UpdateMortgageApplicantStatus(applicantID);
		return null;

	}

	@GetMapping(value = "/submitvaluefrominc/{mortgageID}/{insuredValue}/{MsID}/{deductiblevalue}/{appraisedValue}")
	public MortgageApplicant veriFyDetailsAndPrepareDocument(@PathVariable int mortgageID,
			@PathVariable double insuredValue, @PathVariable int MsID, @PathVariable double deductiblevalue,
			@PathVariable double appraisedValue) {
		MortgageApplicant mort = mortgageApplicantService.UpdateMortgageApplicantDetailsAndStatus(mortgageID,
				appraisedValue, insuredValue, deductiblevalue);
		return mort;
	}
}
