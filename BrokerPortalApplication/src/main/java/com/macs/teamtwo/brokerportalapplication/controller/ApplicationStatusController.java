package com.macs.teamtwo.brokerportalapplication.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;



@Controller
public class ApplicationStatusController {

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	
	// show application status page
	@RequestMapping(value = "/applicationstatus", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "applicationstatus";
	}

	// Process application status
	@RequestMapping(value = "/applicationstatus", method = RequestMethod.POST)
	public ModelAndView processLogin(ModelAndView modelAndView, @Valid MortgageApplicant mortgageApplicant, BindingResult bindingResult,
			HttpServletRequest request) {
		MortgageApplicant applicant = mortgageApplicantService.getApplicantByMortgageID(mortgageApplicant.getMortgageID());
		if (applicant == null) {
			modelAndView.addObject("errorMessage", "applicant does not exists");
		} else
		{
			modelAndView.addObject("successMessage", "Applicant status is : "+applicant.getApplicationStatus());
			System.out.println("status of the Application : "+applicant.getApplicationStatus());
		}
		modelAndView.setViewName("applicationstatus");
		return modelAndView;
	}

}
