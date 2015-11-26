package com.ots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ots.common.OrderSummaryBean;
import com.ots.common.PaymentBean;
import com.ots.dao.OrderDaoImpl;
import com.ots.dao.PaymentDaoImpl;
import com.ots.dao.PlacesDaoImpl;

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

	@Autowired
	private PaymentDaoImpl paymentDaoImpl;
	
	@Autowired
	private PlacesDaoImpl placesDaoImpl;
	/**
	 * This method returns All Orders applicable for selected client
	 * 
	 * @param clientId
	 * @return
	 */
	public List<OrderSummaryBean> fetchAllOrders(String clientId) {
		return orderDaoImpl.getOrders(clientId);
	}

	/**
	 * This method accepts order ids and returns beans corresponding to the
	 * same.
	 * 
	 * @param orderIds
	 * @return
	 *//*
		 * public List<OrderSummaryBean> getOrders(List<String> orderIds) {
		 * return orderDaoImpl.getTotalAmountByOrderIds(orderIds); }
		 */

	/**
	 * This method returns total amount due for selected order ids.
	 * 
	 * @param orderIds
	 * @return
	 */
	public float getTotalAmountToBePaid(List<String> orderIds) {
		float val = orderDaoImpl.getTotalAmountByOrderIds(orderIds);
		System.out.println("===="+val);
		
		return val;
	}
	
	/**
	 * @param paymentBean
	 * @return
	 */
	public Boolean insertPaymentDetails(PaymentBean paymentBean)
	{
		return paymentDaoImpl.insertPaymentDetails(paymentBean);
	}

	/**
	 * @param orderSummaryBean
	 * @return
	 */
	public Boolean updateOrderDetails(OrderSummaryBean orderSummaryBean)
	{
		return orderDaoImpl.updateOrderDetails(orderSummaryBean);
	}

	/**
	 * @param orderSummaryBean
	 * @return
	 */
	public Boolean createOrder(OrderSummaryBean orderSummaryBean)
	{
	return orderDaoImpl.createOrder(orderSummaryBean);
	}
	

	/**
	 * @param userID
	 * @param clientID
	 * @param orderID
	 * @return
	 */
	public Boolean insertPlacesRecord(String userID,String  clientID,String  orderID) throws MySQLIntegrityConstraintViolationException
	{
		return placesDaoImpl.insertPlacesRecord(userID, clientID, orderID);
	}
}
