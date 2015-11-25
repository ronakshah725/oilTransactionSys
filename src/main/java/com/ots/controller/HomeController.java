package com.ots.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ots.service.UserManagementServiceImpl;

@Controller
public class HomeController {

	final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private UserManagementServiceImpl userManagementServiceImpl;

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest request) {
		if (request.getSession().getAttribute("userName") != null) {
			if (request.getSession().getAttribute("isCustomer") != null) {
				return "orderSummary";
			} else {
				return "searchUser";
			}
		} else {
			return "loginInput";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelMap model, HttpServletRequest request, @ModelAttribute LoginBean loginBean) {
		logger.debug("loginBean= " + loginBean);
		model.addAttribute("userName", loginBean.getUserName());
		UserBean user = userManagementServiceImpl.validateAndFetchUserDetails(loginBean.getUserName(),
				loginBean.getPassword());
		logger.debug("userObject found "+user);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			// set Role in session request.getSession().setAttribute("role", user); -use this role in order to decide what to display in the top menu on heading.jsp
			//Do select * from client, trader, get role_id.. based on role_id, fetch list of features user has
			return new ModelAndView("searchUser");
		}
		else
		{
			model.addAttribute("message", "Please check username/password");
			return new ModelAndView( "loginInput");
		}

	}

	/**
	 * This Rest resource returns the user's profile that can be edited.
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile(ModelMap model,HttpServletRequest request) {
		// Populate entire data in the bean here, display the same on
		// editprofile page.
		UserBean userToBeEdited= (UserBean)request.getSession().getAttribute("user");
		userToBeEdited.setPassword(null);
		model.addAttribute("userToBeEdited", userToBeEdited);
		return new ModelAndView("createUser");
	}


	
	/**
	 * This method accepts all search parameters and returns the list of users that match search criteria.
	 * @param model
	 * @param searchUserBean
	 * @return
	 */
	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public String searchUserResult(ModelMap model, @ModelAttribute SearchUserBean searchUserBean) {
		logger.debug("searchUserBean= " + searchUserBean);
		model.addAttribute("search", searchUserBean.getZipCode());
		List<UserBean> usersFromDb = new ArrayList<UserBean>();
		UserBean usb = new UserBean();
		usb.setFirstName("foo");
		usb.setLastName("bar");
		usersFromDb.add(usb);

		UserBean usb2 = new UserBean();
		usb2.setFirstName("foo1");
		usb2.setLastName("bar2");
		usersFromDb.add(usb2);

		model.addAttribute("users", usersFromDb);
		return ("searchUserResult");
	}

	/**
	 * This method will be called when trader/administrator needs to select the user for whom he/she needs to do transactions
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
	public String selectUser(ModelMap model, @RequestParam(required = false) String userId) {
		logger.debug("searchUserBean= " + userId);
		model.addAttribute("userId", userId);
		return ("orderSummary");
	}

	/**
	 * Common Rest API to be used for updating user's profile details or creating a new user.
	 * @param model
	 * @param request
	 * @param userToBeInsertedOrUpdated
	 * @return
	 */
	@RequestMapping(value = "/insertOrUpdateUser", method = RequestMethod.POST)
	public String insertOrUpdateUser(ModelMap model, HttpServletRequest request, 
			@RequestParam(required = false) UserBean userToBeInsertedOrUpdated) {
		logger.debug("userToBeInsertedOrUpdated= " + userToBeInsertedOrUpdated);
		
		
		UserBean userToBeEdited= (UserBean)request.getSession().getAttribute("user");

		
		if(userToBeEdited.getEmailId().trim().equalsIgnoreCase(userToBeInsertedOrUpdated.getEmailId()))
		{
			// this means its an update case
		}
		else
		{
			// this means its a create case.
		}
		
		model.addAttribute("message", " User Added/Updated Successfully");
		return ("orderSummary");
	}

	/**
	 * This rest API accepts list of Order ids and cancels the same
	 * @param model
	 * @param orderIds
	 * @return
	 */
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
	public String cancelOrder(ModelMap model, @RequestParam(required = false) List<String> orderIds) {
		logger.debug("searchUserBean= " + orderIds);
		model.addAttribute("message", "Congratulations! Payment cancellation was successful");
		return ("orderSummary");
	}

	/**
	 * Rest API for returning the home page.
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap map) {
		return "home";
	}
	
	/**
	 * This Rest API returns the Top menu jsp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/topMenu", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model) {
		return new ModelAndView("heading");
	}

	/**
	 * This Api will be used for returning the page that displays the empty "create new User" form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		// Return empty create new user page
		// Do request.getsession().getAttribute - role and see if the role is admin, if it is, return the createUser page 
		// otherwise log user out - call 	return logUserOut(request);
		return  "createUser";
	
	
	
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request, @ModelAttribute LoginBean loginBean) {
		return logUserOut(request);
	}

	/**
	 * @param request
	 * @return
	 */
	private String logUserOut(HttpServletRequest request) {
		request.getSession().invalidate();
		logger.debug("loggingout");
		return "redirect:/";
	}
}
