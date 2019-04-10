package com.macs.teamtwo.brokerportalapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
