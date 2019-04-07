package com.macs.teamtwo.employerportalapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	@RequestMapping(value = "/applicationstatus", method = RequestMethod.GET)
	public String showApplicationStatusPage(ModelMap model) {
		return "applicationstatus";
	}

	// Process application status
	@RequestMapping(value = "/applicationstatus", method = RequestMethod.POST)
	public ModelAndView processApplicantValidityWithBroker(ModelAndView modelAndView,@RequestParam("applicationNumber") String applicationNumber,@RequestParam("link") String link) {
		//invoke web service of broker provided link
		//get link and get ApplicationNumbe from user and then invoke web service
		//String applicationNumberVal="App-24936eba-cf9b-4e18-93a2-78eb49f815ed"; // for testing
		boolean validApplicant=employeeService.getEmployeeByApplicationNumber(applicationNumber,link);
		
		 if(validApplicant)
		    {
		    	//modelAndView.addObject("successMessage", "Employee Authenticated Sucessfully from Broker");
		    	modelAndView.setViewName("applicationstatus");
		    	modelAndView.addObject("successMessage", "Employee Authenticated Sucessfully from Broker");
		    }else
		    {
		    	modelAndView.addObject("errorMessage", "Could not  Authenticate Employee for Broker");
		    }
			
		return modelAndView;
		
	}

}


