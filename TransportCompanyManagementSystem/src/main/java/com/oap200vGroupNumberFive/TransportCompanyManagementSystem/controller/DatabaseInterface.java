package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.controller;

import com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Migle Adomonyte 
 * 
 * This class represents database interface. 
 * The code is based on ExampleApp. 
 */

public interface DatabaseInterface {
	/**
	 * Open connection.
	 * 
	 * @throws SQLException
	 */
	void open() throws SQLException;

	/**
	 * Close connection.
	 * 
	 * @throws SQLException
	 */
	void close() throws SQLException;

	/**
	 * Test connection.
	 * 
	 * @throws SQLException
	 */
	void test() throws SQLException;
	
	
	/**********************
	 *                    *
	 * CUSTOMER FUNCTIONS *
	 *                    *
	 **********************/
	
	
	/**
	 * Method for retrieving a list of customers from database it selects all 
	 * customers without any applied filter. 
	 * @return List of Customer objects.
	 * @throws SQLException
	 */
	List<Customer> getCustomers() throws SQLException;
	
	/**
	 * Method for retrieving a list of customers from database that are from the 
	 * specified city. 
	 * 
	 * @param city   The city of the customer. 
	 * @return List of Customer objects filtered by city. 
	 * @throws SQLException
	 */
	Customer getCustomerByNumber(int customerNumber) throws SQLException;
	
	/**
	 * Method for retrieving the last customer number. 
	 * 
	 * @return Customer number. 
	 * @throws SQLException
	 */
	int getLastCustomerNumber() throws SQLException;
	
	/**
	 * Method for adding a new employee to the database. 
	 * 
	 * @param customerNumber          Customer number.
	 * @param customerName            Customer's name. 
	 * @param contactFirstName        First name of the contact person. 
	 * @param contactLastName         Last name of the contact person. 
	 * @param phone                   Phone number. 
	 * @param addressLine1            Address line 1. 
	 * @param addressLine2            Address line 2. 
	 * @param city                    City.
	 * @param postalCode              Postal code. 
	 * @param country                 Country.
	 * @param salesRepEmployeeNumber  Sales representative employee number. 
	 * @param creditLimit             Credit limit. 
	 * @throws SQLException
	 */
	void addCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, 
			String country, int salesRepEmployeeNumber, double creditLimit) throws SQLException;
	
	/**
	 * Method for updating a customer information in the database. 
	 * 
	 * @param customerName            Customer's name. 
	 * @param contactFirstName        First name of the contact person. 
	 * @param contactLastName         Last name of the contact person. 
	 * @param phone                   Phone number. 
	 * @param addressLine1            Address line 1. 
	 * @param addressLine2            Address line 2. 
	 * @param city                    City.
	 * @param postalCode              Postal code. 
	 * @param country                 Country.
	 * @param salesRepEmployeeNumber  Sales representative employee number. 
	 * @param creditLimit             Credit limit. 
	 * @throws SQLException
	 */
	void updateCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, 
			String country, int salesRepEmployeeNumber, double creditLimit) throws SQLException;
	
	/**
	 * Method for deleting a customer based on the customer number. 
	 * 
	 * @param customerNumber          Customer number.
	 * @throws SQLException
	 */
	void deleteCustomer(int customerNumber) throws SQLException;
	
	
	/**********************
	 *                    *
	 * EMPLOYEE FUNCTIONS *
	 *                    *
	 **********************/
	
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Employee> getEmployees() throws SQLException;
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Integer> getEmployeeNumber()throws SQLException;
	
	
	
	
	/**********************
	 *                    *
	 *  ORDER FUNCTIONS   *
	 *                    *
	 **********************/
	
	
	// Add Order
	// View Orders Based on Customer
	// Update Order Status 
	
	
	
	/**********************
	 *                    *
	 * PRODUCT FUNCTIONS  *
	 *                    *
	 **********************/
	
	
	
	
	/**********************
	 *                    *
	 *  OFFICE FUNCTIONS  *
	 *                    *
	 **********************/
	
	
	
	
	/**********************
	 *                    *
	 * PAYMENTS FUNCTIONS *
	 *                    *
	 **********************/
	
}
