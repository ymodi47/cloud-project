package com.macs.teamtwo.brokerportalapplication.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.Config;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;

@Controller
public class RegistrationController {
	
	private static final Logger logger = Logger.getLogger(RegistrationController.class);
	
	public static final String MBR_PORTAL =Config.getProperty("brokerPortal");

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	// show registration
	@GetMapping(value = "/mortgageapplicationform")
	public ModelAndView showSignUpPage(ModelAndView modelAndView) {
		modelAndView.setViewName("mortgageapplicationform");
		return modelAndView;
	}

	// Process form input data
	@PostMapping(value = "/mortgageapplicationform")
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid MortgageApplicant mortgageApplicant,
			HttpSession session) {

		MortgageApplicant addedMortgageApplicant = mortgageApplicantService.addMortgageApplicant(mortgageApplicant);
		if (addedMortgageApplicant != null) {
			modelAndView.addObject("successMessage", "Application submitted Sucessfully");
			String Link = MBR_PORTAL + "/mortgageapplicant/";
			logger.info(" Link to be used by employer :" + Link);
			modelAndView.addObject("link", Link);
			modelAndView.addObject("MortageID", addedMortgageApplicant.getApplicantID());
			modelAndView.addObject("applicantName", addedMortgageApplicant.getapplicantName());
			modelAndView.addObject("mortVal", addedMortgageApplicant.getMortgageValue());
			modelAndView.addObject("mortID", addedMortgageApplicant.getmSID());
			modelAndView.addObject("empname", addedMortgageApplicant.getEmployerName());

		} 
		modelAndView.setViewName("mortgageapplicationform");
		return modelAndView;
	}

}
