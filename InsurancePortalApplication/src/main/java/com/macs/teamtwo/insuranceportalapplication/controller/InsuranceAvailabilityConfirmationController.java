package com.macs.teamtwo.insuranceportalapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.macs.teamtwo.insuranceportalapplication.domain.MIsIDDetails;
import com.macs.teamtwo.insuranceportalapplication.service.InsuranceEvaluatorService;

@RestController
public class InsuranceAvailabilityConfirmationController {

	@Autowired
	InsuranceEvaluatorService insuranceEvaluatorService;

	// Once the form is submitted, the RE organizes the appraisal
	// of the property MortID and then it submits the appraisal to the INSinc by
	// invoking the INSinc’s web service with
	// parameters MortID and appraised $ value.
	@GetMapping(value = "/insurancedetails/{MIsID}")
	public MIsIDDetails constructQuote(@PathVariable int MIsID) {
		return insuranceEvaluatorService.constructQuote(MIsID);

	}
}
