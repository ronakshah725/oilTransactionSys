package com.ots.common;

import java.util.Date;

/**
 * Bean for User Name
 * 
 * @author Madhuri
 *
 */
public class OrderSummaryBean {
	
	private String orderId;
	private Date date;
	private String type;
	private float quantity;
	private int status;
	private float amount;
	private float commissionindollar;
	private float commisisioninoil;
	private String paymentId;
	
	
	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/**
	 * @return the commissionindollar
	 */
	public float getCommissionindollar() {
		return commissionindollar;
	}
	/**
	 * @param commissionindollar the commissionindollar to set
	 */
	public void setCommissionindollar(float commissionindollar) {
		this.commissionindollar = commissionindollar;
	}
	/**
	 * @return the commisisioninoil
	 */
	public float getCommisisioninoil() {
		return commisisioninoil;
	}
	/**
	 * @param commisisioninoil the commisisioninoil to set
	 */
	public void setCommisisioninoil(float commisisioninoil) {
		this.commisisioninoil = commisisioninoil;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	

}
