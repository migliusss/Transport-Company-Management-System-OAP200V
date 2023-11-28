package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.controller;

import com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Migle Adomonyte 
 * @author Elias Rønningen 
 * 
 * This class represents database interface. 
 * The code is based on ExampleApp. 
 */

public interface DatabaseInterface {
	/**********************
	 *                    *
	 * DATABASE FUNCTIONS *
	 *                    *
	 **********************/
	
	
	/**
	 * Open connection to the database.
	 * 
	 * @throws SQLException
	 */
	void open() throws SQLException;

	/**
	 * Close connection to the database.
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
	 * 
	 * @return List of Customer objects.
	 * @throws SQLException
	 */
	List<Customer> getCustomers() throws SQLException;
	
	/**
	 * Method for retrieving a customer from the database filtered by customer number. 
	 * 
	 * @param customerNumber       Customer number. 
	 * @return lastCustomerNumber  Customer Customer object. 
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
	 * Method for updating an existing customer in the database. 
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
	 * Method for retrieving a list of employees from database it selects all 
	 * employees without any applied filter. 
	 * 
	 * @return List of Customer objects.
	 * @throws SQLException
	 */
	List<Employee> getEmployees() throws SQLException;
	
	/**
	 * Method for retrieving all employee numbers. 
	 * 
	 * @return List of employee numbers. 
	 * @throws SQLException
	 */
	List<Integer> getEmployeeNumber() throws SQLException;
	
	/**
	 * Method for retrieving an employee from the database filtered by employee number. 
	 * 
	 * @param employeeNumber  Employee number. 
	 * @return Employee       Employee object. 
	 * @throws SQLException
	 */
	Employee getEmployeeByNumber(int employeeNumber) throws SQLException;
	
	/**
	 * Method for retrieving the last employee number. 
	 * 
	 * @return lastEmployeeNumber  Employee number.
	 * @throws SQLException
	 */
	int getLastEmployeeNumber() throws SQLException;

	/**
	 * Method for adding a new employee to the database. 
	 * 
	 * @param employeeNumber    Employee number. 
	 * @param lastName          Last name. 
	 * @param firstName         First name. 
	 * @param extension         Extension number of the employee. 
	 * @param email             Email address. 
	 * @param officeCode        Office code. 
	 * @param reportsTo         Employee number the employee reports to. 
	 * @param jobTitle          Job title. 
	 * @throws SQLException
	 */
	void addEmployee(int employeeNumber, String lastName, String firstName, String extension, 
			String email, String officeCode, int reportsTo, String jobTitle) throws SQLException;
	
	/**
	 * Method for updating an existing employee in the database. 
	 * 
	 * @param employeeNumber    Employee number. 
	 * @param lastName          Last name. 
	 * @param firstName         First name. 
	 * @param extension         Extension number of the employee. 
	 * @param email             Email address. 
	 * @param officeCode        Office code. 
	 * @param reportsTo         Employee number the employee reports to. 
	 * @param jobTitle          Job title. 
	 * @throws SQLException
	 */
	void updateEmployee(int employeeNumber, String lastName, String firstName, String extension, 
			String email, String officeCode, int reportsTo, String jobTitle) throws SQLException;
	
	/**
	 * Method for deleting an employee in the database based on the employee number. 
	 * 
	 * @param employeeNumber  Employee number. 
	 * @throws SQLException
	 */
	void deleteEmployee(int employeeNumber) throws SQLException;
	
	
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
	
	
	 /**
      * Method for retrieving a list of all products from the database.
      * 
      * @return A list of Product objects representing the products retrieved from the database. 
      * @throws SQLException 
      */
    List<Product> getProducts() throws SQLException;
    
	 /**
      * Method for retrieving a list of all product names from database.
      *
      * @return A list of distinct Product names. 
      * @throws SQLException 
      */
    List<String> getProductName() throws SQLException;
    
    
    /**
     * Method for retrieving the quantity in stock for the selected product. 
     * 
     * @param selectedProductName  The selected product name. 
     * @return quantity            Quantity in stock for the selected product. 
     * @throws SQLException
     */
    int getQuantityByName(String selectedProductName) throws SQLException;
    
    /**
     * Method to update the quantity for the selected product name. 
     * The user can choose between increasing and deceasing the stock. 
     * 
     * @param productName       Product name. 
     * @param quantityToUpdate  Quantity to update. 
     * @param isAddition        True or false determines operation. 
     * @throws SQLException
     */
    void updateQuantityInStock(String productName, int quantityToUpdate, boolean isAddition) throws SQLException;
    
	
	/**********************
	 *                    *
	 *  OFFICE FUNCTIONS  *
	 *                    *
	 **********************/
	
    
    /**
     * Method for retrieving office codes from the database. 
     * 
     * @return List of office codes. 
     * @throws SQLException
     */
	List<String> getOfficeCode() throws SQLException;
	
	
	/**********************
	 *                    *
	 * PAYMENTS FUNCTIONS *
	 *                    *
	 **********************/
	
	
	
	
	
	/**********************
	 *                    *
	 *   FILE FUNCTIONS   *
	 *                    *
	 **********************/
	
    
    /**
     * Method for retrieving table names from the database. 
     * @return
     * @throws SQLException
     */
	List<String> getTableNames() throws SQLException; 
	
    /**
     * Method for writing a chosen table from the database to a file. 
     * 
     * @param tableName      Table name. 
     * @param filePath       File path. 
     * @throws SQLException
     */
    void saveTableToFile(String tableName, String filePath) throws SQLException;
}
