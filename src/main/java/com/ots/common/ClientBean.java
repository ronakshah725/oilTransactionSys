package com.ots.common;

import java.util.Date;

/**
 * Client Bean
 * 
 * @author kanchan
 *
 */
public class ClientBean {

	private String clientId;
	private Date dateOfLevelUpgrade;
	private Double totalOilQuantity;
	private Double balanceAmount;
	private String level;
	UserBean userBean ;
	

	/**
	 * @return the dateOfLevelUpgrade
	 */
	public Date getDateOfLevelUpgrade() {
		return dateOfLevelUpgrade;
	}

	/**
	 * @param dateOfLevelUpgrade
	 *            the dateOfLevelUpgrade to set
	 */
	public void setDateOfLevelUpgrade(Date dateOfLevelUpgrade) {
		this.dateOfLevelUpgrade = dateOfLevelUpgrade;
	}

	/**
	 * @return the totalOilQuantity
	 */
	public Double getTotalOilQuantity() {
		return totalOilQuantity;
	}

	/**
	 * @param totalOilQuantity
	 *            the totalOilQuantity to set
	 */
	public void setTotalOilQuantity(Double totalOilQuantity) {
		this.totalOilQuantity = totalOilQuantity;
	}

	/**
	 * @return the balanceAmount
	 */
	public Double getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * @param balanceAmount
	 *            the balanceAmount to set
	 */
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientBean [clientId=" + clientId + ", dateOfLevelUpgrade=" + dateOfLevelUpgrade + ", totalOilQuantity="
				+ totalOilQuantity + ", balanceAmount=" + balanceAmount + ", level=" + level + ", userBean=" + userBean
				+ "]";
	}
 

 
}
