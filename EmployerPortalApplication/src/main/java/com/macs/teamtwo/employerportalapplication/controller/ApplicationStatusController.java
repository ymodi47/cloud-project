package com.macs.teamtwo.employerportalapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.employerportalapplication.service.EmployeeService;

@Controller
public class ApplicationStatusController {

	@Autowired
	EmployeeService employeeService;

	
	// show application status page
	@GetMapping(value = "/applicationstatus")
	public String showApplicationStatusPage(ModelMap model) {
		return "applicationstatus";
	}

	// Process application status
	@PostMapping(value = "/applicationstatus")
	public ModelAndView processApplicantValidityWithBroker(ModelAndView modelAndView,@RequestParam("applicationNumber") String applicationNumber,@RequestParam("link") String link) {
		boolean validApplicant=employeeService.getEmployeeByApplicationNumber(applicationNumber,link);
		
		 if(validApplicant)
		    {
		    	modelAndView.setViewName("applicationstatus");
		    	modelAndView.addObject("successMessage", "Employee Authenticated Sucessfully from Broker");
		    }else
		    {
		    	modelAndView.addObject("errorMessage", "Could not  Authenticate Employee for Broker");
		    }
			
		return modelAndView;
		
	}

}


