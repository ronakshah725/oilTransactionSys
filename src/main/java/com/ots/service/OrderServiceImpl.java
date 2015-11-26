package com.ots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ots.common.ClientBean;
import com.ots.common.OrderSummaryBean;
import com.ots.common.TraderBean;
import com.ots.common.UserBean;
import com.ots.dao.ClientDaoImpl;
import com.ots.dao.OrderDaoImpl;
import com.ots.dao.TraderDaoImpl;
import com.ots.dao.UserDaoImpl;

/**
 * This service will be used for supporting UserManagement and login tasks
 * 
 * @author kanchan
 *
 */
@Service
public class OrderServiceImpl {

	@Autowired
	private OrderDaoImpl orderDaoImpl;
	 
	/**
	 * This method returns All Orders applicable for selected client
	 * @param clientId
	 * @return
	 */
	public List<OrderSummaryBean> fetchAllOrders(String clientId) {
	return orderDaoImpl.getOrders(clientId);
	}
 
 }
