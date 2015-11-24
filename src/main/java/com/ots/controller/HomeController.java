package com.ots.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ots.common.LoginBean;
import com.ots.common.SearchUserBean;
import com.ots.common.UserBean;
  
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) 
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView  login( ModelMap model,HttpServletRequest request, @ModelAttribute  LoginBean loginBean ) 
	{
		System.out.println("loginBean= "+loginBean);
		 model.addAttribute("userName",loginBean.getUserName());
		 request.getSession().setAttribute("userName", loginBean.getUserName());
		return new ModelAndView("searchUser");
	}
	
	 
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public String  searchUserResult( ModelMap model, @ModelAttribute  SearchUserBean searchUserBean ) 
	{
		System.out.println("searchUserBean= "+searchUserBean);
		 model.addAttribute("search",searchUserBean.getZipCode());
		 List<UserBean> usersFromDb = new ArrayList<UserBean>();
		 UserBean usb = new UserBean();
		 usb.setFirstName("foo");
		 usb.setLastName("bar");
		 usersFromDb.add(usb);
		 
		 UserBean usb2 = new UserBean();
		 usb2.setFirstName("foo1");
		 usb2.setLastName("bar2");
		 usersFromDb.add(usb2);
		 
		 model.addAttribute("users",usersFromDb);
		return ("searchUserResult");
	}
	
	@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
	public String  selectUser( ModelMap model, @RequestParam(required=false) String userId) 
	{
		System.out.println("searchUserBean= "+userId);
		 model.addAttribute("userId",userId);
		return ("orderSummary");
	}
	
	
	 
  }
