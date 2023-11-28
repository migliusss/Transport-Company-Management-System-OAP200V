package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.controller;

import com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
 * @author Elias Rønningen
 * 
 * Based on provided ExampleApp. 
 * 
 * Class that provides details for the DB connectivity.
 * It assumes that you have proper MySQL JDBC driver.
 * 
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
	private final String DB_URL = "jdbc:mysql://localhost/classicmodels?autoReconnect=true&useSSL=false";

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
		
		try {
			// Open the database connection. 
			this.open();
			
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
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return customers;
	}

	@Override
	public Customer getCustomerByNumber(int customerNumber) throws SQLException {
		// Variable for storing the Customer object. 
		Customer customer = null;
		
		try {
			// Open the database connection. 
			this.open();
			
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
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return customer;
	}
	
	@Override
	public int getLastCustomerNumber() throws SQLException {
		int lastCustomerNumber = 0;
		
		try {
			// Open the database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT MAX(customerNumber) FROM customers");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Check that the results are not empty. 
			if (resultSet.next()) {
				lastCustomerNumber = resultSet.getInt(1);   
			}         
			// Close the database connection. 
			close();
			
		} catch (SQLException e) {
            e.printStackTrace();
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
		// Create a list of Customers. 
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			// Open the database connection. 
			this.open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT * FROM employees");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// A while loop for collecting results and creating Employee objects. 
			while(resultSet.next()) {
				int employeeNumber = resultSet.getInt("employeeNumber");
				String lastName = resultSet.getString("lastName");
				String firstName = resultSet.getString("firstName");
				String extensions = resultSet.getString("extension");
				String email = resultSet.getString("email");
				String officeCode = resultSet.getString("officeCode");
				int reportsTo = resultSet.getInt("reportsTo");
				String jobTitle = resultSet.getString("jobTitle");
				
				Employee current = new Employee(employeeNumber, lastName, firstName, extensions, 
						email, officeCode, reportsTo, jobTitle);
				
				// Add the Employee object to the Customer ArrayList.
				employees.add(current);
			}
			
			// Close the database connection. 
			close();
			
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return employees;
	}
	
	@Override
	public List<Integer> getEmployeeNumber() throws SQLException {
		// Create list for storing employee numbers. 
		List<Integer> employeeNumbers = new ArrayList<>();
		
		try {
			// Open database connection.
			open();
			
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
	
	@Override
	public Employee getEmployeeByNumber(int employeeNumber) throws SQLException {
		// Variable for storing the Customer object. 
		Employee employee = null;
		
		try {
			// Open the database connection. 
			this.open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE employeeNumber=?");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setInt(1, employeeNumber);
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Check that the results exist. 
			if (resultSet.next()) {
				String lastName = resultSet.getString("lastName");
				String firstName = resultSet.getString("firstName");
				String extensions = resultSet.getString("extension");
				String email = resultSet.getString("email");
				String officeCode = resultSet.getString("officeCode");
				int reportsTo = resultSet.getInt("reportsTo");
				String jobTitle = resultSet.getString("jobTitle");
				
				// Create an Employee object based on the data. 
				employee = new Employee(employeeNumber, lastName, firstName, extensions, 
						email, officeCode, reportsTo, jobTitle);
			}
			
			// Close the database connection. 
			close();
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return employee;
	}

	@Override
	public int getLastEmployeeNumber() throws SQLException {
		int lastEmployeeNumber = 0;
		
		try {
			// Open the database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT MAX(employeeNumber) FROM employees");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Check that the results are not empty. 
			if (resultSet.next()) {
				lastEmployeeNumber = resultSet.getInt(1);   
			}         
			// Close the database connection. 
			close();
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		return lastEmployeeNumber;
	}
	
	@Override
	public void addEmployee(int employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, int reportsTo, String jobTitle) throws SQLException {
		try {
			// Open the database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("INSERT INTO employees "
					+ "(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setInt(1, employeeNumber);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, extension);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, officeCode);
			preparedStatement.setInt(7, reportsTo);
			preparedStatement.setString(8, jobTitle);
			
			// Execute the SQL statement. 
			preparedStatement.executeUpdate();
			
			// Close the database connection. 
			close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, int reportsTo, String jobTitle) throws SQLException {
		try {
			// Open database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("UPDATE employees SET lastName=?, "
					+ "firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=? WHERE employeeNumber=?");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setString(1, lastName);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, extension);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, officeCode);
			preparedStatement.setInt(6, reportsTo);
			preparedStatement.setString(7, jobTitle);
			preparedStatement.setInt(8, employeeNumber);
			
			// Execute the SQL statement. 
			preparedStatement.executeUpdate();
						
			// Close the database connection. 
			close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int employeeNumber) throws SQLException {
		try {
			// Open database connection. 
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE employeeNumber=?");
			
			// Set the parameter values for the SQL statement. 
			preparedStatement.setInt(1, employeeNumber);
			
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
	 *  ORDER FUNCTIONS   *
	 *                    *
	 **********************/
	
	
	
	
	
	/**********************
	 *                    *
	 * PRODUCT FUNCTIONS  *
	 *                    *
	 **********************/
	
	
    @Override
    public List<Product> getProducts() throws SQLException {
    	// Create list for storing products.  
        ArrayList<Product> products = new ArrayList<Product>();
        
        try {
            // Open database connection.
            this.open();
            
        	// Prepare the SQL statement. 
        	preparedStatement = connection.prepareStatement("SELECT * FROM products");
        	
        	// Execute the SQL statement. 
        	resultSet = preparedStatement.executeQuery();

			// Iterate through the results and add products to the list. 
            while (resultSet.next()) {
                String productCode = resultSet.getString("productCode");
                String productName = resultSet.getString("productName");
                String productLine = resultSet.getString("productLine");
                String productScale = resultSet.getString("productScale");
                String productVendor = resultSet.getString("productVendor");
                String productDescription = resultSet.getString("productDescription");
                int quantityInStock = resultSet.getInt("quantityInStock");
                float buyPrice = resultSet.getFloat("buyPrice");
                float MSRP = resultSet.getFloat("MSRP");

                Product current = new Product(productCode, productName, productLine, productScale, 
                		productVendor, productDescription, quantityInStock, buyPrice, MSRP);
				// Add the Product object to the Product ArrayList.
                products.add(current);
            }
            
			// Close the database connection. 
            close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
	@Override
    public List<String> getProductName() throws SQLException {
    	// Create list for storing product names. 
        ArrayList<String> productNames = new ArrayList<String>();
        
        try {
            // Open database connection.
            this.open();
            
        	// Prepare the SQL statement. 
        	preparedStatement = connection.prepareStatement("SELECT DISTINCT productName FROM products");
        	
        	// Execute the SQL statement. 
        	resultSet = preparedStatement.executeQuery();
        	
			// Iterate through the results and add the product names to the list. 
            while (resultSet.next()) {
                String fetchedProductName = resultSet.getString("productName");
                
                // Check that the results are not empty. 
                if (fetchedProductName != null) {
                    productNames.add(fetchedProductName);
                }

            }
            
			// Close the database connection. 
            close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productNames;
    }

	@Override
    public int getQuantityByName(String selectedProductName) throws SQLException {
        // Variable for storing the product quantity. 
        int quantity = 0;
        
        try {
            // Open database connection.
            this.open();
            
        	// Prepare the SQL statement. 
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE productName = ?");
            
			// Set the parameter values for the SQL statement. 
            preparedStatement.setString(1, selectedProductName);

        	// Execute the SQL statement. 
            resultSet = preparedStatement.executeQuery();
            
			// Check that the results are not empty. 
            if (resultSet.next()) {
                quantity = resultSet.getInt("quantityInStock");
            }
            
			// Close the database connection. 
            close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
	
	@Override
    public void updateQuantityInStock(String productName, int quantityToUpdate, boolean isAddition) throws SQLException {
		try {
			// Open the database connection
			open(); 
			
            // Determine the operation, addition or subtraction. 
            String operator = (isAddition) ? "+" : "-";

            // Prepare the SQL statement to update the quantity in stock by adding or subtracting. 
            preparedStatement = connection.prepareStatement(
            		"UPDATE products SET quantityInStock = quantityInStock " + operator + " ? WHERE productName = ?");

            // Set the parameters in the prepared statement. 
            preparedStatement.setInt(1, quantityToUpdate);
            preparedStatement.setString(2, productName);

            // Execute the update statement
            preparedStatement.executeUpdate();
            
			// Close the database connection. 
            close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	/**********************
	 *                    *
	 *  OFFICE FUNCTIONS  *
	 *                    *
	 **********************/
	
	
	@Override
	public List<String> getOfficeCode() throws SQLException {
		// Create list for storing employee numbers. 
		List<String> officeCodes = new ArrayList<>();
		
		try {
			// Open database connection.
			open();
			
			// Prepare the SQL statement. 
			preparedStatement = connection.prepareStatement("SELECT officeCode FROM offices");
			
			// Execute the SQL statement. 
			resultSet = preparedStatement.executeQuery();
			
			// Iterate through the results and add the officeCode to the list. 
	        while (resultSet.next()) {
	            String officeCode = resultSet.getString("officeCode");
	            officeCodes.add(officeCode);
	        }
	        
			// Close the database connection. 
			close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
        return officeCodes;
	}
	
	
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
	

	@Override
    public List<String> getTableNames() throws SQLException {
    	// Create list for storing table names. 
        List<String> tableNames = new ArrayList<>();

        try {
            // Open database connection.
            this.open();
            
        	// Prepare the SQL statement. 
            preparedStatement = connection.prepareStatement("SHOW TABLES");

        	// Execute the SQL statement. 
            resultSet = preparedStatement.executeQuery();
            
			// Iterate through the results and add the table names to the list. 
            while (resultSet.next()) {
                String tableName = resultSet.getString(1);
                tableNames.add(tableName);
            }
            
			// Close the database connection. 
            close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableNames;
    }

	@Override
    public void saveTableToFile(String tableName, String filePath) throws SQLException {
        try {
            open(); // Open the database connection

            // Prepare the SQL statement to select all rows from the specified table. 
            preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName);
            
        	// Execute the SQL statement. 
            resultSet = preparedStatement.executeQuery();

            // Write the results to the specified file. 
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            
            // Write column names as headers
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    writer.write(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            
            writer.write("\n");

            // Iterate through the results and write each row to the file. 
            while (resultSet.next()) {
            	for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            		writer.write(resultSet.getString(i) + "\t");
            	}
            	writer.write("\n");
            }
            
			// Close the database connection. 
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
