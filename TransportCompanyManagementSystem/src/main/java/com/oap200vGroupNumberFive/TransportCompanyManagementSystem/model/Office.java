package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author Migle Adomonyte
 * This class represent an office in the system. 
 */

public class Office {
	private String officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory;
	
	/**
	 * Constructor for creating a new office. 
	 * 
	 * @param officeCode      Office code. 
	 * @param city            City. 
	 * @param phone           Phone number. 
	 * @param addressLine1    Address line 1. 
	 * @param addressLine2    Address line 2.
	 * @param state           State. 
	 * @param country         Country. 
	 * @param postalCode      Postal code. 
	 * @param territory       Territory. 
	 */
	Office(String officeCode, String city, String phone, String addressLine1,  String addressLine2, String state, String country, 
			String postalCode, String territory) {
		
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}

	/**
	 * Getter for officeCode.
	 * @return Office code. 
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * Setter for officeCode. 
	 * @param officeCode Office code to set. 
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	/**
	 * Getter for city. 
	 * @return City. 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter for city. 
	 * @param city City to set. 
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter for phone. 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for phone.
	 * @param phone Phone number to set. 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Getter for address line 1. 
	 * @return Address line 1. 
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Setter for address line 1. 
	 * @param addressLine1 Address line 1 to set. 
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Getter for address line 2. 
	 * @return Address line 2. 
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Setter for address line 2. 
	 * @param addressLine2 Address line 2 to set. 
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Getter for state. 
	 * @return State. 
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter for state. 
	 * @param state State to set. 
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Getter for country
	 * @return Country. 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Setter for country. 
	 * @param country Country to set. 
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Getter for postal code. 
	 * @return Postal code. 
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Setter for postal code. 
	 * @param postalCode Postal code to set. 
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Getter for territory. 
	 * @return Territory
	 */
	public String getTerritory() {
		return territory;
	}

	/**
	 * Setter for territory.
	 * @param territory Territory to set. 
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}

}
