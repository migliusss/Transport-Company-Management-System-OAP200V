package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.controller;

import com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Migle Adomonyte
 * 
 * The code is based on ExampleApp. 
 * 
 * Class that provides details for the DB connectivity.
 * It assumes that you have proper MySQL JDBC driver.
 * 
 * How to use this class?
 * 
 * 1. Create new object. DBHelper db = new DBHelper();
 * 2. Open connection. db.open();
 * 3. Call corresponding method. db.test();
 * 4. Close connection. db.close;
  
 * jdbc driver can be found at: http://www.java2s.com/Code/Jar/c/Downloadcommysqljdbc515jar.htm
 */

public class DatabaseHelper implements DatabaseInterface {

	// JDBC driver name and database URL.
	private final String DB_URL = "jdbc:mysql://localhost/classicmodels";

	// Database credentials.
	private static final String USERNAME = "student";
	private static final String PASSWORD = "student";

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	@Override
	public void open() throws SQLException {
		try {
			// Establish connection.
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			// Create statement that will be used for executing SQL queries.
			statement = connection.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void close() throws SQLException {
		try {
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void test() throws SQLException {
		try {
			String sql = "SELECT * FROM customers";
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("customerNumber") + resultSet.getString("customerName"));
			}
			
			resultSet.close();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	/**********************
	 *                    *
	 * CUSTOMER FUNCTIONS *
	 *                    *
	 **********************/

	
	@Override
	public List<Customer> getCustomers() throws SQLException {
		// Create a list of Customers. 
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		// Open the database connection. 
		this.open();
		
		try {
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT * FROM customers");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// A while loop for collecting results and creating Customer objects. 
			while(resultSet.next()) {
				int customerNumber = resultSet.getInt("customerNumber");
				String customerName = resultSet.getString("customerName");
				String contactLastName = resultSet.getString("contactLastName");
				String contactFirstName = resultSet.getString("contactFirstName");
				String phone = resultSet.getString("phone");
				String addressLine1 = resultSet.getString("addressLine1");
				String addressLine2 = resultSet.getString("addressLine2");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String postalCode = resultSet.getString("postalCode");
				String country = resultSet.getString("country");
				int salesRepEmployeeNumber = resultSet.getInt("salesRepEmployeeNumber");
				double creditLimit = resultSet.getDouble("creditLimit");
				
				Customer current = new Customer(customerNumber, customerName, contactLastName, contactFirstName, 
						phone, addressLine1, addressLine2, city, state, postalCode, 
						country, salesRepEmployeeNumber, creditLimit);
				
				// Add the Customer object to the Customer ArrayList.
				customers.add(current);
			}
			// Close the database connection. 
			close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getCustomerByNumber(int customerNumber) throws SQLException {
		// Variable for storing the Customer object. 
		Customer customer = null;
		
		// Open the database connection. 
		this.open();
		
		try {
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE customerNumber=?");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setInt(1, customerNumber);
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Check that the results exist. 
			if (resultSet.next()) {
				String customerName = resultSet.getString("customerName");
				String contactLastName = resultSet.getString("contactLastName");
				String contactFirstName = resultSet.getString("contactFirstName");
				String phone = resultSet.getString("phone");
				String addressLine1 = resultSet.getString("addressLine1");
				String addressLine2 = resultSet.getString("addressLine2");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String postalCode = resultSet.getString("postalCode");
				String country = resultSet.getString("country");
				int salesRepEmployeeNumber = resultSet.getInt("salesRepEmployeeNumber");
				double creditLimit = resultSet.getDouble("creditLimit");
				
				// Create a Customer object based on the data. 
				customer = new Customer(customerNumber, customerName, contactLastName, contactFirstName, 
						phone, addressLine1, addressLine2, city, state, postalCode, 
						country, salesRepEmployeeNumber, creditLimit);
			}
			
			// Close the database connection. 
			close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return customer;
	}
	
	@Override
	public int getLastCustomerNumber() throws SQLException {
		int lastCustomerNumber = 0;
		
		// Open the database connection. 
		open();
		
		try {
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT MAX(customerNumber) FROM customers");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Check that the results exist. 
			if (resultSet.next()) {
				lastCustomerNumber = resultSet.getInt(1);   
			}         
			// Close the database connection. 
			close();
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		return lastCustomerNumber;
	}

	@Override
	public void addCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, int salesRepEmployeeNumber, double creditLimit) throws SQLException {
		try {
			// Open the database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("INSERT INTO customers "
					+ "(customerNumber, customerName, contactLastName, contactFirstName, phone, "
					+ "addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setInt(1, customerNumber);
			preparedStatement.setString(2, customerName);
			preparedStatement.setString(3, contactLastName);
			preparedStatement.setString(4, contactFirstName);
			preparedStatement.setString(5, phone);
			preparedStatement.setString(6, addressLine1);
			preparedStatement.setString(7, addressLine2);
			preparedStatement.setString(8, city);
			preparedStatement.setString(9, state);
			preparedStatement.setString(10, postalCode);
			preparedStatement.setString(11, country);
			preparedStatement.setInt(12, salesRepEmployeeNumber);
			preparedStatement.setDouble(13, creditLimit);
			
			// Execute the SQL statement. 
			preparedStatement.executeUpdate();
			
			// Close the database connection. 
			close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName, String phone,
			String addressLine1, String addressLine2, String city, String state, String postalCode, String country,
			int salesRepEmployeeNumber, double creditLimit) throws SQLException {
		try {
			// Open database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("UPDATE customers SET customerName=?, contactLastName=?, "
					+ "contactFirstName=?, phone=?, addressLine1=?, addressLine2=?, city=?, state=?, postalCode=?, "
					+ "country=?, salesRepEmployeeNumber=?, creditLimit=? WHERE customerNumber=?");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setString(1, customerName);
			preparedStatement.setString(2, contactLastName);
			preparedStatement.setString(3, contactFirstName);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, addressLine1);
			preparedStatement.setString(6, addressLine2);
			preparedStatement.setString(7, city);
			preparedStatement.setString(8, state);
			preparedStatement.setString(9, postalCode);
			preparedStatement.setString(10, country);
			preparedStatement.setInt(11, salesRepEmployeeNumber);
			preparedStatement.setDouble(12, creditLimit);
			preparedStatement.setInt(13, customerNumber);
			
			// Execute the SQL statement. 
			preparedStatement.executeUpdate();
						
			// Close the database connection. 
			close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(int customerNumber) throws SQLException {
		try {
			// Open database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE customerNumber=?");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setInt(1, customerNumber);
			
			// Execute the SQL statement. 
			preparedStatement.executeUpdate();
						
			// Close the database connection. 
			close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**********************
	 *                    *
	 * EMPLOYEE FUNCTIONS *
	 *                    *
	 **********************/
	
	
	@Override
	public List<Employee> getEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getEmployeeNumber() throws SQLException {
		// Create list for storing employee numbers. 
		List<Integer> employeeNumbers = new ArrayList<>();
		
		// Open database connection.
		open();
		
		try {
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT employeeNumber FROM employees");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Iterate through the results and add the employee number to the list. 
	        while (resultSet.next()) {
	            int employeeNumber = resultSet.getInt("employeeNumber");
	            employeeNumbers.add(employeeNumber);
	        }
	        
			// Close the database connection. 
			close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
        return employeeNumbers;
	}
	
	
	/**********************
	 *                    *
	 *  ORDER FUNCTIONS   *
	 *                    *
	 **********************/
	
	
	
	
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
