package com.macs.teamtwo.realstateportalapplication.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.realstateportalapplication.service.AppraiserValueEvaluatorService;

@Controller
public class AppraisalRateEvaluatorController {

	@Autowired
	AppraiserValueEvaluatorService appraiserValueEvaluatorService;

	// show form
	@GetMapping(value = "/appraiservalue")
	public ModelAndView showLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("realEstateStatus");
		return modelAndView;
	}

	// Process form input data
	@PostMapping(value = "/appraiservalue")
	public ModelAndView processForm(ModelAndView modelAndView, @Valid MortgageApplicant applicant) {
		double appraseValue=appraiserValueEvaluatorService.getAppraiserValueByMortgageAndMSID(applicant.getMortgageID(),applicant.getMSID());
		return modelAndView.addObject("appraiserValue",appraseValue);
	}

}
