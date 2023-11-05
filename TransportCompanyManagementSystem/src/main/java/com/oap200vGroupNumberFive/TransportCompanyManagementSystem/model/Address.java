package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author Migle Adomonyte
 * This class represents an address in the system. 
 */

public class Address {
	/**
	 * Address line 1. 
	 */
	private String addressLine1;

	/**
	 * Address line 2. 
	 */
	private String addressLine2;
	
	/**
	 * The city. 
	 */
	private String city; 
	
	/**
	 * The state. 
	 */
	private String state; 
	
	/**
	 * The postal code. 
	 */
	private String postalCode;
	
	/**
	 * The country. 
	 */
	private String country; 
	
	/**
	 * Constructor for creating a new address.
	 */
	Address() {
	}
	
	/**
	 * Constructor for creating a new address.
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param state
	 * @param postalCode
	 * @param country
	 */
	Address(String addressLine1, String addressLine2, String city, String state, 
			String postalCode, String country) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	/**
	 * Getter for addressLine1. 
	 * @return addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Setter for addressLine1. 
	 * @param addressLine1
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Getter for addressLine2. 
	 * @return addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Setter for addressLine2.
	 * @param addressLine2
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Getter for city. 
	 * @return city 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter for city. 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter for state. 
	 * @return state 
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter for state. 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Getter for postalCode. 
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Setter for postalCode.
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Getter for country. 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Setter for country. 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * A method for displaying the full address. 
	 */
	public void displayFullAddress() {
		System.out.println("Address Line 1: " + this.addressLine1);
		System.out.println("Address Line 2: " + this.addressLine2);
		System.out.println("City: " + this.city);
		System.out.println("State: " + this.state);
		System.out.println("Postal Code: " + this.postalCode);
		System.out.println("Country: " + this.country);
	}
}
