package com.macs.teamtwo.brokerportalapplication.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.Config;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;



@Controller
public class ApplicationStatusController {

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	
	// show application status page
	@RequestMapping(value = "/applicationstatus", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model,HttpSession session) {
		return "applicationstatus";
	}
	
	
	// Process form input data
		@RequestMapping(value = "/applicationstatus", method = RequestMethod.POST)
		public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid MortgageApplicant mortgageApplicant,HttpSession session) {

			MortgageApplicant addedMortgageApplicant=mortgageApplicantService.getApplicationStatus(mortgageApplicant.getApplicantID(), mortgageApplicant.getPassword());
			if(addedMortgageApplicant!=null)
			{
				modelAndView.addObject("statusMessage", "Application status is  : "+addedMortgageApplicant.getApplicationStatus());
				//modelAndView.addObject("applicationStatus",addedMortgageApplicant.getApplicationStatus());
				modelAndView.setViewName("mortgageapplicationform");
				return modelAndView	;

			} else {
				modelAndView.addObject("errorMessage", "Applicant not found.");
			}
			modelAndView.setViewName("mortgageapplicationform");
			return modelAndView;
		}


}
