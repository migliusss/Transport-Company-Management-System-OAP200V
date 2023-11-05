package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author Migle Adomonyte
 * This class represents a customer in the system. 
 * It provides methods for customer management. 
 */

public class Customer {
	/**
	 * Static counter to track the last assigned customerNumber. 
	 */
	private static int lastCustomerNumber = 0; // HUSK: Må telle antall rader i Customers tabellen for å få riktig tall.  
	
	/**
	 * The unique customer identifier. 
	 */
	private int customerNumber;

	/**
	 * The name of the customer's company. 
	 */ 
	private String customerName;
	
	/**
	 * The last name of the company's representative. 
	 */
	private String contactLastName;
	
	/**
	 * The first name of the company's representative. 
	 */
	private String contactFirstName;
	
	/**
	 * The phone number of the company's representative. 
	 */
	private String phone;
	
	/**
	 * The address of the company. 
	 */
	private Address address;
	
	/**
	 * The responsible sales representative. 
	 */
	// private Employee salesRepEmployeeNumber; 
	
	/**
	 * The mount that a customer can use for making purchases. 
	 */
	private double creditLimit;
	
	/**
	 * Constructor for creating a new customer. 
	 */
	Customer() {
	}
	
	/**
	 * Constructor for creating a new customer. 
	 * @param customerName
	 * @param contactLastName
	 * @param contactFirstName
	 * @param phone
	 * @param creditLimit
	 * @param address
	 */
	Customer(String customerName, String contactLastName, String contactFirstName, 
			String phone, double creditLimit, Address address){
		// Increment the lastCustomerNumber. 
		lastCustomerNumber++;
		
		// Set the customer properties. 
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.creditLimit = creditLimit;
		this.address = address;
	}
	
	/**
	 * Getter for lastCustomerNumber
	 * @return lastCustomerNumber
	 */
	public static int getLastCustomerNumber() {
		return lastCustomerNumber;
	}

	/**
	 * Setter for lastCustomerNumber. 
	 * @param lastCustomerNumber
	 */
	public static void setLastCustomerNumber(int lastCustomerNumber) {
		Customer.lastCustomerNumber = lastCustomerNumber;
	}

	/**
	 * Getter for customerNumber.
	 * @return customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Setter for customerNumber.
	 * @param customerNumber
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * Getter for customerNumber.
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Setter for customerName. 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * Getter for contactLastname.
	 * @return contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * Setter for contactLastName.
	 * @param contactLastName
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * Setter for contactFirstName. 
	 * @return contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}
	
	/**
	 * Setter contactFirstName.
	 * @param contactFirstName
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
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
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Getter for address. 
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Setter for address. 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Getter for creditLimit. 
	 * @return creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}

	/**
	 * Setter for creditLimit. 
	 * @param creditLimit
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	/*
	 * A method for display customer information. 
	 */
	public void displayCustomerInfo() {
		System.out.println("Customer Number: " + this.customerNumber);
		System.out.println("Customer Name: " + this.customerName);
		System.out.println("Customer Contact Last Name: " + this.contactLastName);
		System.out.println("Customer Contact First Name: " + this.contactFirstName);
		System.out.println("Customer Phone: " + this.phone);
		System.out.println("Customer Address: " + this.address);
		System.out.println("Customer Credit Limit: " + this.creditLimit);
	}
	
}
