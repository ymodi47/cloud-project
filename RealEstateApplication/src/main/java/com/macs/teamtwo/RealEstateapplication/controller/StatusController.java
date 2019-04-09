package com.macs.teamtwo.RealEstateapplication.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.RealEstateapplication.domain.RealEstate;
import com.macs.teamtwo.RealEstateapplication.service.RealEstateService;

@Controller
public class StatusController {

	@Autowired
	RealEstateService realEstateService;


	// show registration
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("realEstateStatus");
		return modelAndView;
	}

	// Process form input data
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public ModelAndView processLoginForm(ModelAndView modelAndView, @Valid RealEstate realEstate) {
		    
		    RealEstate emp=realEstateService.getEmployeeByEmailAndPassword(realEstate.getEmail(), realEstate.getPassword());
		    if(emp!=null)
		    {
		    	modelAndView.addObject("successMessage", "RealEstate Authenticated Sucessfully");
		    	modelAndView.setViewName("applicationstatus");
		    }else
		    {
		    	modelAndView.addObject("errorMessage", "Incorrect Email-Id or Password ");
		    }
			
		return modelAndView;
	}

}
