package com.macs.teamtwo.brokerportalapplication.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;

@Controller
public class ApplicationStatusController {
	
	private static final Logger logger = Logger.getLogger(ApplicationStatusController.class);

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	// show application status page
	@GetMapping(value = "/applicationstatus")
	public String showLoginPage(ModelMap model, HttpSession session) {
		return "applicationstatus";
	}

	// Process form input data
	@PostMapping(value = "/applicationstatus")
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid MortgageApplicant mortgageApplicant,
			HttpSession session) {
		MortgageApplicant addedMortgageApplicant = mortgageApplicantService
				.getApplicationStatus(mortgageApplicant.getApplicantID(), mortgageApplicant.getPassword());
		if (addedMortgageApplicant != null) {
			modelAndView.addObject("statusMessage",
					"Application status is  : " + addedMortgageApplicant.getApplicationStatus());
			logger.info("Application status is : "+addedMortgageApplicant.getApplicationStatus());
			modelAndView.setViewName("mortgageapplicationform");
			return modelAndView;
		} else {
			modelAndView.addObject("errorMessage", "Applicant not found.");
		}
		modelAndView.setViewName("mortgageapplicationform");
		return modelAndView;
	}

}
