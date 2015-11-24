package com.ots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ots.common.LoginBean;
import com.ots.common.SearchUserBean;
  
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) 
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView  login( ModelMap model, @ModelAttribute  LoginBean loginBean ) 
	{
		System.out.println("loginBean= "+loginBean);
		 model.addAttribute("userName",loginBean.getUserName());
		return new ModelAndView("searchUser");
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public ModelAndView  searchUserResult( ModelMap model, @ModelAttribute  SearchUserBean searchUserBean ) 
	{
		System.out.println("searchUserBean= "+searchUserBean);
		 model.addAttribute("search",searchUserBean.getZipCode());
		return new ModelAndView("searchUserResult");
	}
	
	
	 
  }
