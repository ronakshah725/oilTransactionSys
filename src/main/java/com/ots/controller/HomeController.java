package com.ots.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

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

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ots.common.ClientBean;
import com.ots.common.LoginBean;
import com.ots.common.OrderSummaryBean;
import com.ots.common.PaymentBean;
import com.ots.common.PlaceOrderBean;
import com.ots.common.TraderBean;
import com.ots.common.UserBean;
import com.ots.service.OrderServiceImpl;
import com.ots.service.UserManagementServiceImpl;

@Controller
public class HomeController {

	final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private UserManagementServiceImpl userManagementServiceImpl;

	@Autowired
	private OrderServiceImpl orderSerivceImpl;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") != null) {
			if (request.getSession().getAttribute("selectedClient") != null) {
				return loadOrderSummaries(model, request);
			} else {
				return new ModelAndView("searchUser");
			}
		} else {
			return new ModelAndView("loginInput");
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelMap model, HttpServletRequest request, @ModelAttribute LoginBean loginBean) {
		logger.debug("loginBean= " + loginBean);
		model.addAttribute("userName", loginBean.getUserName());
		UserBean user = userManagementServiceImpl.validateAndFetchUserDetails(loginBean.getUserName(),
				loginBean.getPassword());
		logger.debug("userObject found " + user);
		
		ResourceBundle bundle= ResourceBundle.getBundle("config");
		request.getSession().setAttribute("oil_price",Integer.parseInt(bundle.getString("oil_price").trim()));
		
		
		if (user != null) {
			List<String> features = null;
			request.getSession().setAttribute("user", user);
			ClientBean clientBean = userManagementServiceImpl.getClientDetails(user.getId());

			if (clientBean != null) {
				request.getSession().setAttribute("selectedClient", clientBean);
				System.out.println("settting===?>" + request.getSession().getAttribute("selectedClient"));
				features = userManagementServiceImpl.getClientFeatureCodes(clientBean.getClientId());
				return loadOrderSummaries(model, request);

			} else {
				TraderBean traderBean = userManagementServiceImpl.getTraderDetails(user.getId());
				if (traderBean == null) {
					model.addAttribute("message",
							"User has not been properly set up yet. Please contact administrator");
					return new ModelAndView("loginInput");
				} else {
					features = userManagementServiceImpl.getTraderFeatureCodes(traderBean.getRoleId());
				}
			}
			System.out.println("-->" + features);
			if (features != null && features.size() != 0) {
				for (String feature : features) {
					request.getSession().setAttribute(feature, "true");
				}
			}
			return new ModelAndView("searchUser");
		} else {
			model.addAttribute("message", "Please check username/password");
			return new ModelAndView("loginInput");
		}

	}

	/**
	 * This Rest resource returns the user's profile that can be edited.
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile(ModelMap model, HttpServletRequest request) {
		UserBean userToBeEdited = (UserBean) request.getSession().getAttribute("user");
		userToBeEdited.setPassword(null);
		model.addAttribute("userToBeEdited", userToBeEdited);
		return new ModelAndView("createUser");
	}

	/**
	 * This method accepts all search parameters and returns the list of users
	 * that match search criteria.
	 * 
	 * @param model
	 * @param searchUserBean
	 * @return
	 */
	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public String searchUserResult(ModelMap model, @ModelAttribute UserBean searchUserBean) {
		logger.debug("searchUserBean= " + searchUserBean);

		List<UserBean> usersFromDb = userManagementServiceImpl.searchUser(searchUserBean);
		logger.debug("usersFromDb" + usersFromDb);
		model.addAttribute("searchResult", usersFromDb);
		return ("searchUserResult");
	}

	/**
	 * This method will be called when trader/administrator needs to select the
	 * user for whom he/she needs to do transactions
	 * 
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
	public ModelAndView selectUser(ModelMap model, HttpServletRequest request,
			@RequestParam(required = false) String userId) {
		logger.debug("searchUserBean= " + userId);
		ClientBean bean = userManagementServiceImpl.getClientDetails(userId);
		request.getSession().setAttribute("selectedClient", bean);
		model.addAttribute("userId", userId);
		return loadOrderSummaries(model, request);
	}

	/**
	 * Common Rest API to be used for updating user's profile details or
	 * creating a new user.
	 * 
	 * @param model
	 * @param request
	 * @param userToBeInsertedOrUpdated
	 * @return
	 */
	@RequestMapping(value = "/insertOrUpdateUser", method = RequestMethod.POST)
	public ModelAndView insertOrUpdateUser(ModelMap model, HttpServletRequest request,
			@ModelAttribute UserBean userToBeInsertedOrUpdated) {
		logger.debug("userToBeInsertedOrUpdated= " + userToBeInsertedOrUpdated);

		UserBean userToBeEdited = (UserBean) request.getSession().getAttribute("user");
		/*
		 * if (userToBeEdited.getEmailId().trim().equalsIgnoreCase(
		 * userToBeInsertedOrUpdated.getEmailId())) { // this means its an
		 * 
		 * --> Edit profile to be implemented later. update case } else {
		 */
		model.addAttribute("userToBeEdited", userToBeInsertedOrUpdated);
		if (!userToBeInsertedOrUpdated.getPassword1().equals(userToBeInsertedOrUpdated.getPassword2())) {
			model.addAttribute("message", " Please make sure both the passwords match");
			return new ModelAndView("createUser");
		}

		userToBeInsertedOrUpdated.setPassword(userToBeInsertedOrUpdated.getPassword1());
		Boolean result = userManagementServiceImpl.insertUser(userToBeInsertedOrUpdated);
		logger.debug("result" + result);
		if (result == null || !result) {
			model.addAttribute("message", " Error occured while saving details. Please relogin");

			return new ModelAndView("createUser");
		} else {
			model.addAttribute("message", " User Created successfully.");
		}
		/* } */

		model.addAttribute("message", " User Added/Updated Successfully");
		return loadOrderSummaries(model, request);
	}

	/**
	 * This rest API accepts list of Order ids and cancels the same
	 * 
	 * @param model
	 * @param orderIds
	 * @return
	 */
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
	public ModelAndView cancelOrder(ModelMap model, @RequestParam(required = false) String orderIds,
			HttpServletRequest request) {
		logger.debug("searchUserBean= " + orderIds + " : ");

		ClientBean clientBean = (ClientBean) request.getSession().getAttribute("selectedClient");
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		try {
			for (String orderId : orderIds.split(",")) {
				if (orderId != null) {
					userManagementServiceImpl.insertIntoCancel(user, clientBean, orderId);
					model.addAttribute("message", "Congratulations! Payment cancellation was successful");
				}
			}

			userManagementServiceImpl.updateOilAndBalanceOfClient(clientBean.getClientId(),
					(clientBean.getBalanceAmount()
							+ orderSerivceImpl.getTotalAmountToBePaid(Arrays.asList(orderIds.split(",")))),
					clientBean.getTotalOilQuantity());
			clientBean = userManagementServiceImpl.getClientDetails(clientBean.getUserBean().getId());
			request.getSession().setAttribute("selectedClient", clientBean);

		} catch (MySQLIntegrityConstraintViolationException mse) {
			mse.printStackTrace();
			model.addAttribute("message", "Exception occured while deleting, please logout and try again.");
		}

		return loadOrderSummaries(model, request);
	}

	/**
	 * This rest API accepts list of Order ids and makes the payment
	 * 
	 * @param model
	 * @param orderIds
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String makePayment(ModelMap model, HttpServletRequest request,
			@RequestParam(required = false) String orderIds) {
		logger.debug("orderIds= " + orderIds);
		for (String string : orderIds.split(",")) {
			System.out.println("-->" + string);
		}
		request.getSession().setAttribute("orderIds", orderIds);
		// Check if user has appropriate role or not if user does not has
		// CANCEL_ORDER feature access, reject and log user out
		ClientBean clientBean = (ClientBean) request.getSession().getAttribute("selectedClient");
		Long orderCost = new Float(orderSerivceImpl.getTotalAmountToBePaid(Arrays.asList(orderIds.split(","))) * 100
				+ clientBean.getBalanceAmount()*100).longValue();
		
		System.out.println("orders_total_Amout: "+orderCost);
		
		model.addAttribute("amountDue", 
				orderCost);
		
		model.addAttribute("balAmount", clientBean.getBalanceAmount() + "$");
		return ("payment");
	}

	/**
	 * This rest API accepts the payment
	 * 
	 * @param model
	 * @param orderIds
	 * @return
	 */
	@RequestMapping(value = "/paymentAccepted", method = RequestMethod.POST)
	public String paymentAccepted(ModelMap model, HttpServletRequest request) {

		// Check if user has appropriate role or not if user does not has
		// CANCEL_ORDER feature access, reject and log user out
		List<String> orderIds = Arrays.asList((String) request.getSession().getAttribute("orderIds"));
		PaymentBean paymentBean = new PaymentBean();
		String payId = UUID.randomUUID().toString();
		paymentBean.setPaymentId(payId);
		ClientBean clientBean = (ClientBean) request.getSession().getAttribute("selectedClient");
		UserBean user = (UserBean) request.getSession().getAttribute("user");

		paymentBean.setClientId(clientBean.getClientId());
		paymentBean.setTraderId(user.getId());
		paymentBean.setDateAccepted(Calendar.getInstance().getTime());
		paymentBean.setAmount((orderSerivceImpl.getTotalAmountToBePaid(orderIds) + clientBean.getBalanceAmount()));
		System.out.println(paymentBean);

		userManagementServiceImpl.updateOilAndBalanceOfClient(clientBean.getClientId(), new Float(0.0),
				clientBean.getTotalOilQuantity());
		clientBean = userManagementServiceImpl.getClientDetails(clientBean.getUserBean().getId());
		request.getSession().setAttribute("selectedClient", clientBean);

		orderSerivceImpl.insertPaymentDetails(paymentBean);

		for (String orderId : orderIds) {
			OrderSummaryBean orderSummaryBean = new OrderSummaryBean();
			if (orderId.trim().length() != 0) {
				orderSummaryBean.setOrderId(orderId);
				orderSummaryBean.setPaymentId(payId);
				System.out.println("updating " + orderSummaryBean);
				orderSerivceImpl.updateOrderDetails(orderSummaryBean);
			}
		}
		model.addAttribute("message", "Congratulations! Payment  was successful");

		logger.debug("Stripe token= " + request.getSession().getAttribute("stripeToken"));
		logger.debug("Stripe type= " + request.getSession().getAttribute("stripeTokenType"));
		return "redirect:/";
	}

	/**
	 * Rest API for returning the home page.
	 * 
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
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/topMenu", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model) {
		return new ModelAndView("heading");
	}

	/**
	 * This Rest API returns the Top menu jsp
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loadOrders", method = RequestMethod.GET)
	public ModelAndView loadOrders(ModelMap model, HttpServletRequest request) {
		return loadOrderSummaries(model, request);
	}

	/**
	 * @param model
	 * @param request
	 * @return
	 */
	private ModelAndView loadOrderSummaries(ModelMap model, HttpServletRequest request) {
		ClientBean clientBean = (ClientBean) request.getSession().getAttribute("selectedClient");
		request.getSession().removeAttribute("orderIds");
		List<OrderSummaryBean> orders = orderSerivceImpl.fetchAllOrders(clientBean.getClientId());
		System.out.println(orders);
		model.addAttribute("orders", orders);
		return new ModelAndView("orderSummary");
	}

	/**
	 * This Api will be used for returning the page that displays the empty
	 * "create new User" form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		// Return empty create new user page
		// Do request.getsession().getAttribute - getFEATURES and see if the
		// there is a FEATURE called INSERT_USER, if it is, return the
		// createUser page
		// otherwise log user out - call return logUserOut(request);
		return "createUser";

	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(ModelMap model) {
		// Return empty create new user page
		// Do request.getsession().getAttribute - getFEATURES and see if the
		// there is a FEATURE called INSERT_USER, if it is, return the
		// createUser page
		// otherwise log user out - call return logUserOut(request);
		return "placeorder";

	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ModelAndView placeOrder(ModelMap model, HttpServletRequest request,
			@ModelAttribute PlaceOrderBean placeOrderBean) {
		logger.debug("order created= " + placeOrderBean);
		OrderSummaryBean orderSummaryBean = new OrderSummaryBean();

		String ordId = UUID.randomUUID().toString();
		orderSummaryBean.setOrderId(ordId);
		orderSummaryBean.setDate(Calendar.getInstance().getTime());
		orderSummaryBean.setType(placeOrderBean.getType());
		orderSummaryBean.setQuantity(placeOrderBean.getQuantity());
		orderSummaryBean.setCommissionType(placeOrderBean.getCommissionType());
		orderSummaryBean.setAmount(placeOrderBean.getQuantity() * ((Integer)request.getSession().getAttribute("oil_price")));

		if (placeOrderBean.getCommissionType().equals("Oil")) {
			orderSummaryBean.setCommisisioninoil((float) orderSummaryBean.getQuantity() * (float) 0.02);
			orderSummaryBean.setCommissionindollar(new Float(0.0));
		} else {
			orderSummaryBean.setCommissionindollar(orderSummaryBean.getAmount() * (float) 0.02);
			orderSummaryBean.setCommisisioninoil(new Float(0.0));
		}

		orderSummaryBean.setQuantity((orderSummaryBean.getQuantity() - orderSummaryBean.getCommisisioninoil()));
		orderSummaryBean.setAmount((orderSummaryBean.getAmount() + orderSummaryBean.getCommissionindollar()));

		System.out.println("after applying commission" + orderSummaryBean);

		orderSerivceImpl.createOrder(orderSummaryBean);
		ClientBean clientBean = (ClientBean) request.getSession().getAttribute("selectedClient");
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		try {
			orderSerivceImpl.insertPlacesRecord(user.getId(), clientBean.getClientId(), ordId);

			Float userAcountOilQty = clientBean.getTotalOilQuantity();
			if (placeOrderBean.getType().equals("buy")) {
				userAcountOilQty += orderSummaryBean.getQuantity();
			} else {
				userAcountOilQty -= orderSummaryBean.getQuantity();
			}
			userManagementServiceImpl.updateOilAndBalanceOfClient(clientBean.getClientId(),
					clientBean.getBalanceAmount(), userAcountOilQty);
			clientBean = userManagementServiceImpl.getClientDetails(clientBean.getUserBean().getId());
			request.getSession().setAttribute("selectedClient", clientBean);

		} catch (MySQLIntegrityConstraintViolationException mse) {
			model.addAttribute("message", "Exception occured while deleting, please logout and try again.");
		}
		return loadOrderSummaries(model, request);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap modesetttingl, HttpServletRequest request, @ModelAttribute LoginBean loginBean) {
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
