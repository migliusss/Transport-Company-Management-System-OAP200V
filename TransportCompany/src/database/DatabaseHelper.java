package database;
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




public class DatabaseHelper implements DatabaseInterface {

	/**
	 * JDBC (including removal of SSL warning) and credentials for database connection 
	 */
	private final String DB_URL = "jdbc:mysql://localhost:3306/classicmodels?autoReconnect=true&&useSSL=false";
	private final String USER = "student";
	private final String PASS = "student"; 
    
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement prepStmt = null;
    private ResultSet rSet = null;
    
    /**
     * Based on provided ExampleApp
    * Establishes a connection to database and permits execution of SQL queries.
     *
     * @throws to SQLException for any errors.
	 */
    @Override
    public void open() throws SQLException{
        try {
            //Establish connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //Create statement that will be used for executing SQL queries
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();// More elegant solutions for catching errors exist but they are out of the scope for this course
        }
    }
    
    /**
     * Based on provided ExampleApp
     * Kills connection to database 
     *
     * @throws to SQLException for any errors.
     */
    @Override
    public void close() throws SQLException{
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
    }

	public void test() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	 /**
	     * Retrieves a list of all products from the database.
	     * 
	     * @return a list of Products objects representing the products retrieved from the database
	     * @throws SQLException if an error occurs while accessing the database
	     */
	    @Override
	    public List<Products> getProducts() throws SQLException {
	        ArrayList<Products> products = new ArrayList<Products>();
	        this.open();
	        try {
	            prepStmt = conn.prepareStatement("SELECT * FROM products");
	            rSet = prepStmt.executeQuery();

	            while (rSet.next()) {
	                String productCode = rSet.getString("productCode");
	                String productName = rSet.getString("productName");
	                String productLine = rSet.getString("productLine");
	                String productScale = rSet.getString("productScale");
	                String productVendor = rSet.getString("productVendor");
	                String productDescription = rSet.getString("productDescription");
	                int quantityInStock = rSet.getInt("quantityInStock");
	                float buyPrice = rSet.getFloat("buyPrice");
	                float MSRP = rSet.getFloat("MSRP");

	                Products current = new Products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
	                products.add(current);
	            }
	            return products;
	        } catch (Exception exc) {
	            exc.printStackTrace();
	        }
	        return null;
	    }
	    
	    @Override
        public List<String> getProductName() throws SQLException {
            ArrayList<String> productNames = new ArrayList<String>();
            this.open();
            try {
                prepStmt = conn.prepareStatement("SELECT DISTINCT productName FROM products");
                rSet = prepStmt.executeQuery();

                while (rSet.next()) {
                    String fetchedProductName = rSet.getString("productName");
                    if(fetchedProductName != null) {

                        productNames.add(fetchedProductName);
                    }

                }
                return productNames;
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            return null;
	    }
	    
	    public int getQuantityByName(String selectedProductName) throws SQLException {
	        int quantity = 0;
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "SELECT * FROM products WHERE productName = ?"
	            );
	            prepStmt.setString(1, selectedProductName);

	            ResultSet resultSet = prepStmt.executeQuery();
	            if (resultSet.next()) {
	                quantity = resultSet.getInt("quantityInStock");
	            }

	            close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return quantity;
	    }
	    

	 // Inside the DatabaseHelper class
	    public void updateQuantityInStock(String productName, int quantityToUpdate, boolean isAddition) throws SQLException {
	        try {
	            open(); // Open the database connection

	            // Determine the operation (addition or subtraction)
	            String operator = (isAddition) ? "+" : "-";

	            // Prepare the SQL statement to update the quantity in stock by adding or subtracting
	            String updateQuery = "UPDATE products SET quantityInStock = quantityInStock " + operator + " ? WHERE productName = ?";
	            prepStmt = conn.prepareStatement(updateQuery);

	            // Set the parameters in the prepared statement
	            prepStmt.setInt(1, quantityToUpdate);
	            prepStmt.setString(2, productName);

	            // Execute the update statement
	            prepStmt.executeUpdate();
	        } finally {
	            close(); // Close the database connection in a 'finally' block to ensure it happens even if an exception is thrown
	        }
	    }
	    
	    @Override
	    public List<String> getTableNames() throws SQLException {
	        List<String> tableNames = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
	             PreparedStatement preparedStatement = connection.prepareStatement("SHOW TABLES");
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                String tableName = resultSet.getString(1);
	                tableNames.add(tableName);
	            }
	        }

	        return tableNames;
	    }
	    
	 // Inside the DatabaseHelper class
	    public void saveTableToFile(String tableName, String filePath) throws SQLException {
	        try {
	            open(); // Open the database connection

	            // Prepare the SQL statement to select all rows from the specified table
	            String selectQuery = "SELECT * FROM " + tableName;
	            prepStmt = conn.prepareStatement(selectQuery);
	            rSet = prepStmt.executeQuery();

	            // Write the results to the specified file
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	                // Write column names as headers
	                for (int i = 1; i <= rSet.getMetaData().getColumnCount(); i++) {
	                    writer.write(rSet.getMetaData().getColumnName(i) + "\t");
	                }
	                writer.write("\n");

	                // Write each row to the file
	                while (rSet.next()) {
	                    for (int i = 1; i <= rSet.getMetaData().getColumnCount(); i++) {
	                        writer.write(rSet.getString(i) + "\t");
	                    }
	                    writer.write("\n");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            close(); // Close the database connection in a 'finally' block to ensure it happens even if an exception is thrown
	        }
	    }



}