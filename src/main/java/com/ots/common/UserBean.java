package com.ots.common;

import java.util.UUID;

import org.hibernate.id.UUIDGenerator;

/**
 * Bean for User Name
 * 
 * @author Madhuri
 *
 */
public class UserBean {

	private String id;
	private String firstName;
	private String lastName;
	private String apartmentNumber;
	private String street;
	private String city;
	private String state;
	private Integer zipcode;
	private Integer phoneNumber;
	private Integer cellPhoneNumber;
	private String emailId;
	private String password;
	private String password1;
	private String password2;
	private String companyId;
	private UserType userType;

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the password1
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password1
	 *            the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2
	 *            the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the apartmentNumber
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * @param apartmentNumber
	 *            the apartmentNumber to set
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public Integer getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the phoneNumber
	 */
	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the cellPhoneNumber
	 */
	public Integer getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	/**
	 * @param cellPhoneNumber
	 *            the cellPhoneNumber to set
	 */
	public void setCellPhoneNumber(Integer cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", apartmentNumber="
				+ apartmentNumber + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", phoneNumber=" + phoneNumber + ", cellPhoneNumber=" + cellPhoneNumber + ", emailId="
				+ emailId + ", password=" + password + ", password1=" + password1 + ", password2=" + password2
				+ ", userType=" + userType + "]";
	}

}
