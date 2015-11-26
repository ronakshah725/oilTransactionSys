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

import javassist.compiler.ast.Pair;

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
	 * This method returns Quantity of Oil to be adjusted and Amount to be added to the user's account
	 * 
	 * @param orderIds
	 * @return
	 */
	public Float[]  getTotalAmountToBePaid(String clientId, List<String> orderIds) {
		Float[] quantityAndAmount= new Float[2];
		List<OrderSummaryBean> orders = orderDaoImpl.getOrders(clientId);
		quantityAndAmount[0]=new Float(0);
		quantityAndAmount[1]=new Float(0);
		
		for (OrderSummaryBean orderSummaryBean : orders) {
			if(orderIds.contains(orderSummaryBean.getOrderId().trim()))
			{
				if (orderSummaryBean.getType().equals("buy")) {
					quantityAndAmount[0] -= orderSummaryBean.getQuantity();
				} else {
					quantityAndAmount[0]+= orderSummaryBean.getQuantity();
				}
				if(orderSummaryBean.getPaymentId()!=null && orderSummaryBean.getPaymentId().trim().length()>0)
				{
					if (orderSummaryBean.getType().equals("buy")) {
						quantityAndAmount[1]+= orderSummaryBean.getAmount();
					} else {
						quantityAndAmount[1]-= orderSummaryBean.getAmount();
					}
				}
			}
		}
		return quantityAndAmount;
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
