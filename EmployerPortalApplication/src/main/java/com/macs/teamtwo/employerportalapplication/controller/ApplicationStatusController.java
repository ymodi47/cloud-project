package com.macs.teamtwo.employerportalapplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.employerportalapplication.service.EmployeeService;

@Controller
public class ApplicationStatusController {
	
	private static final Logger logger = Logger.getLogger(ApplicationStatusController.class);

	@Autowired
	EmployeeService employeeService;

	// show application status page
	@GetMapping(value = "/applicationstatus")
	public String showApplicationStatusPage(ModelMap model) {
		return "applicationstatus";
	}

	// Process application status
	@PostMapping(value = "/applicationstatus")
	public ModelAndView processApplicantValidityWithBroker(ModelAndView modelAndView,
			@RequestParam("applicationNumber") String applicationNumber, @RequestParam("link") String link,HttpServletRequest request) {
		boolean validApplicant = employeeService.getEmployeeByApplicationNumber(applicationNumber, link);
		request.getSession().setAttribute("morgageID", applicationNumber);
		if (validApplicant) {
			modelAndView.setViewName("applicationstatus");
			logger.info("Employee Authenticated Sucessfully from Broker.");
			modelAndView.addObject("successMessage", "Employee Authenticated Sucessfully from Broker.");
		} else {
			modelAndView.addObject("errorMessage", "Could not  Authenticate Employee for Broker.");
			logger.info("Could not  Authenticate Employee for Broker.");
		}
		return modelAndView;
	}

}
