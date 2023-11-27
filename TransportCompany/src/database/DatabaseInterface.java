package database;

import java.sql.Date;

import java.sql.SQLException;
import java.util.List; 

/**
 * Provides abstract methods for use with the DatabaseHelper
 */

public interface DatabaseInterface {


	 /**
     * Based on provided ExampleApp
    * Establishes a connection to database and permits execution of SQL queries.
     *
     * @throws to SQLException for any errors.
	 */
	void open() throws SQLException;
	
     /**
     * Based on provided ExampleApp
     * Kills connection to database 
     *
     * @throws to SQLException for any errors.
     */
	void close() throws SQLException;
	
	 /**
     * Based on provided ExampleApp
     * Tests connection to database
      * @throws to SQLException for any errors.
     */
	void test() throws SQLException;
	
	  /**
     * Retrieves a list of all products from the database.
     * 

     * 
     * @return a list of Products objects representing the products retrieved from the database
     * @throws to SQLException for any errors.
     */
    List<Products> getProducts() throws SQLException;
    
	  /**
     * List of all ProductNames from database.
     *
     * @return a list of Products objects representing the products retrieved from the database
     * @throws to SQLException for any errors.
     */
    List<String> getProductName() throws SQLException;

	List<String> getTableNames() throws SQLException; 
	
	
}

