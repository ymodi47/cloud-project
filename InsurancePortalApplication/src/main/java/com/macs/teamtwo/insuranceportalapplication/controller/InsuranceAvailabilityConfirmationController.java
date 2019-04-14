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
	@GetMapping(value = "/insurancedetails/{misID}")
	public MIsIDDetails constructQuote(@PathVariable int misID) {
		return insuranceEvaluatorService.constructQuote(misID);

	}
}