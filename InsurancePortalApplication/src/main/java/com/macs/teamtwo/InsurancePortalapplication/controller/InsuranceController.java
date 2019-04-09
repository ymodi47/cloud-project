package com.macs.teamtwo.InsurancePortalapplication.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.InsurancePortalapplication.domain.Insurance;
import com.macs.teamtwo.InsurancePortalapplication.service.InsuranceService;

@Controller
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;


	// show registration
	@RequestMapping(value = "/insuranceStatus", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("insurancePortal");
		return modelAndView;
	}

	// Process form input data
	@RequestMapping(value = "/insuranceStatus", method = RequestMethod.POST)
	public ModelAndView processLoginForm(ModelAndView modelAndView, @Valid Insurance insurance) {
		    
		    Insurance emp=insuranceService.getEmployeeByEmailAndPassword(insurance.getEmail(), insurance.getPassword());
		    if(emp!=null)
		    {
		    	modelAndView.addObject("successMessage", "Insurance Authenticated Sucessfully");
		    	modelAndView.setViewName("insurancePortal");
		    }else
		    {
		    	modelAndView.addObject("errorMessage", "Incorrect Email-Id or Password ");
		    }
			
		return modelAndView;
	}

}
