package com.macs.teamtwo.realstateportalapplication.controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.realstateportalapplication.service.AppraiserValueEvaluatorService;

@Controller
public class AppraisalRateEvaluatorController {
	
	private static final Logger logger = Logger.getLogger(AppraisalRateEvaluatorController.class);

	@Autowired
	AppraiserValueEvaluatorService appraiserValueEvaluatorService;

	// show form
	@GetMapping(value = "/appraiservalue")
	public ModelAndView showLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("realEstateStatus");
		return modelAndView;
	}

	// get the Appraised Value
	@PostMapping(value = "/appraiservalue")
	public ModelAndView processForm(ModelAndView modelAndView, @Valid MortgageApplicant applicant) {
		MortgageApplicant MortApp = appraiserValueEvaluatorService.getAppraiserValueByMortgageAndMSID(applicant.getMortgageID(),applicant.getmSID(),applicant.getApplicantName());
		modelAndView.addObject("sucessMessage","Your Apprasied value is " + MortApp.getAppraiserValue());
		modelAndView.setViewName("realEstateStatus");
		return modelAndView;
	}

}
