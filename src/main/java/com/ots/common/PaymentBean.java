package com.ots.common;

import java.util.Date;

/**
 * Bean for User Name
 * 
 * @author Madhuri
 *
 */
public class PaymentBean {
	
	private String paymentId;
	private String clientId;
	private Date dateAccepted;
	private String traderId;
	private float amount;
	private float balance;
	
	
	
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the dateAccepted
	 */
	public Date getDateAccepted() {
		return dateAccepted;
	}
	/**
	 * @param dateAccepted the dateAccepted to set
	 */
	public void setDateAccepted(Date dateAccepted) {
		this.dateAccepted = dateAccepted;
	}
	/**
	 * @return the traderId
	 */
	public String getTraderId() {
		return traderId;
	}
	/**
	 * @param traderId the traderId to set
	 */
	public void setTraderId(String traderId) {
		this.traderId = traderId;
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
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
	

}
