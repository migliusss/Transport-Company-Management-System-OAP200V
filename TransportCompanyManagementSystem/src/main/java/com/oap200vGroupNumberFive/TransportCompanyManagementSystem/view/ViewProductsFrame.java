package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Elias Rønningen
 * 
 * This class represents a table of all products in the database. 
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.oap200vGroupNumberFive.TransportCompanyManagementSystem.controller.DatabaseHelper;
import com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model.Product;

public class ViewProductsFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private DatabaseHelper databaseHelper = new DatabaseHelper();
   
	/**
	 * Constructor for creating a new frame that shows a table of all products. 
	 */
    public ViewProductsFrame() {
		// Create a new JFrame. 
		setTitle("All Products");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 500);
		
		// Create a JPanel. 
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(248,249,250));
		setContentPane(panel);
        
        // Table columns
        String[] columnNames = {
                "Product Code", "Product Name", "Product Line", "Product Scale",
                "Product Vendor", "Product Description", "Quantity In Stock",
                "Buy Price", "MSRP"
        };

        // Fetches products through the database helper. 
        List<Product> products;
        try {
            products = databaseHelper.getProducts();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error in retrieving data from the database. " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Create data array for the table
        Object[][] productData = new Object[products.size()][columnNames.length];

        // Populate the data array using enhanced for loop
        int rowIndex = 0;
        for (Product product : products) {
        	productData[rowIndex][0] = product.getProductCode();
        	productData[rowIndex][1] = product.getProductName();
        	productData[rowIndex][2] = product.getProductLine();
        	productData[rowIndex][3] = product.getProductScale();
        	productData[rowIndex][4] = product.getProductVendor();
        	productData[rowIndex][5] = product.getProductDescription();
        	productData[rowIndex][6] = product.getQuantityInStock();
        	productData[rowIndex][7] = product.getBuyPrice();
        	productData[rowIndex][8] = product.getMSRP();

            rowIndex++;
        }

		// Create JTable. 
        JTable table = new JTable(productData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();
        // Set table header. 
        header.setFont(header.getFont().deriveFont(Font.BOLD, 12));
        // Add the scrollpane. 
        add(scrollPane, BorderLayout.CENTER);
        // Automatic resizing
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        setVisible(true);
    }
}
