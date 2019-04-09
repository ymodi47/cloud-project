package com.macs.teamtwo.employerportalapplication.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.employerportalapplication.domain.Employee;
import com.macs.teamtwo.employerportalapplication.service.EmployeeService;

@Controller
public class LoginController {

	@Autowired
	EmployeeService employeeService;


	// show registration
	@GetMapping(value = "/login")
	public ModelAndView showLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
	}

	// Process form input data
	@PostMapping(value = "/login")
	public ModelAndView processLoginForm(ModelAndView modelAndView, @Valid Employee employee) {
		    
		    Employee emp=employeeService.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword());
		    if(emp!=null)
		    {
		    	modelAndView.addObject("successMessage", "Employee Authenticated Sucessfully");
		    	modelAndView.setViewName("applicationstatus");
		    }else
		    {
		    	modelAndView.addObject("errorMessage", "Incorrect Email-Id or Password ");
		    }
			
		return modelAndView;
	}

}
