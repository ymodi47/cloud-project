package com.macs.teamtwo.realstateportalapplication.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.realstateportalapplication.service.AppraiserValueEvaluatorService;


@RestController
public class RealStateAppraisalRateEvaluatorRestController {
	
	private static final Logger logger = Logger.getLogger(RealStateAppraisalRateEvaluatorRestController.class);


	@Autowired
	AppraiserValueEvaluatorService appraiserValueEvaluatorService;

	
	// Verify the Applicant application Number
	@GetMapping(value = "/appraiservalue/{MortgageID}/{mSID}")
	public MortgageApplicant appraiservalue(@PathVariable int MortgageID,@PathVariable int mSID) {
		return appraiserValueEvaluatorService.getAppraiserValueByMortgageAndMSID(MortgageID,mSID, null);
	}

	
}
