package com.ots.common;

public class SearchUserBean {
 
	private String name;
	private String addressPrefix;
	private String city;
	private int zipCode;
	private int phonenumber;
	private int cellphone;
	private String email;
	
	
	/**
	 * @return the phonenumber
	 */
	public int getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the cellphone
	 */
	public int getCellphone() {
		return cellphone;
	}
	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the addressPrefix
	 */
	public String getAddressPrefix() {
		return addressPrefix;
	}
	/**
	 * @param addressPrefix the addressPrefix to set
	 */
	public void setAddressPrefix(String addressPrefix) {
		this.addressPrefix = addressPrefix;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
