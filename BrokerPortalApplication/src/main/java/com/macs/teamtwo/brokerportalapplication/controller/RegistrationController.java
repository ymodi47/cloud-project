package com.macs.teamtwo.brokerportalapplication.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.service.Config;
import com.macs.teamtwo.brokerportalapplication.service.MortgageApplicantService;

@Controller
public class RegistrationController {

	@Autowired
	MortgageApplicantService mortgageApplicantService;

	// show registration
	@RequestMapping(value = "/mortgageapplicationform", method = RequestMethod.GET)
	public ModelAndView showSignUpPage(ModelAndView modelAndView) {
		modelAndView.setViewName("mortgageapplicationform");
		return modelAndView;
	}

	// Process form input data
	@RequestMapping(value = "/mortgageapplicationform", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid MortgageApplicant mortgageApplicant,
			HttpSession session) {

		MortgageApplicant addedMortgageApplicant = mortgageApplicantService.addMortgageApplicant(mortgageApplicant);
		if (addedMortgageApplicant != null) {
			modelAndView.addObject("successMessage", "Application submitted Sucessfully");
			String broker_portal = Config.getProperty("insurancePortalCloudUrl");
			// String cloudhardCodeBrokerUrl="https://brokerportalteam2.azurewebsites.net";
			String localhostHardCode = "http://localhost:8086";
			String Link = localhostHardCode + "/mortgageapplicant/";
			System.out.println(" Link to be used by employer :" + Link);
			modelAndView.addObject("link", Link);
			modelAndView.addObject("MortageID", addedMortgageApplicant.getApplicantID());
			modelAndView.addObject("applicantName", addedMortgageApplicant.getapplicantName());
			modelAndView.addObject("mortVal", addedMortgageApplicant.getMortgageValue());
			modelAndView.addObject("mortID", addedMortgageApplicant.getmSID());
			modelAndView.addObject("empname", addedMortgageApplicant.getEmployerName());

		} else {

			// modelAndView.addObject("errorMessage", "Something went Wrong...");
		}
		modelAndView.setViewName("mortgageapplicationform");
		return modelAndView;
	}

}
