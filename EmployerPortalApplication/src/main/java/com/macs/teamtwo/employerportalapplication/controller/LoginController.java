package com.macs.teamtwo.employerportalapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.macs.teamtwo.employerportalapplication.domain.Employee;
import com.macs.teamtwo.employerportalapplication.service.EmployeeService;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

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
	public ModelAndView processLoginForm(ModelAndView modelAndView, @Valid Employee employee,HttpServletRequest request) {
		    HttpSession session = request.getSession();
		    Employee emp=employeeService.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword());
		    session.setAttribute("email",emp.getEmail());
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
	
	
	@GetMapping(value = "/logout")
	public String processSignOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.invalidate();
		logger.debug("session id after invalidating session is:" + session.getId());
		return "redirect:login";
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
		return "redirect:login";
	}

}
