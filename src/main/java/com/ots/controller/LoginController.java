package com.ots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ots.common.LoginBean;
  
@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) 
	{
		
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView  login( ModelMap model, @ModelAttribute  LoginBean loginBean ) 
	{
		System.out.println("loginBean= "+loginBean);
		 model.addAttribute("a", "b");
		return new ModelAndView("searchUser");
	}
 }
