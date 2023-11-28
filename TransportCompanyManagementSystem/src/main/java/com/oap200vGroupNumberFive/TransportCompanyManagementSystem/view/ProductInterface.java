package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.view;

/**
 * @author Elias Rønninger 
 * 
 * This class represents product menu frame. 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ProductInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for creating a product frame.
	 */
	public ProductInterface() {
		// Create a new JFrame. 
		setTitle("Products");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setResizable(false);
		
		// Create a new JPanel for storing components. 
        JPanel contentPane = new JPanel(new GridLayout(3, 1, 5, 5));
        contentPane.setBackground(new Color(248, 249, 250));
        setContentPane(contentPane);
		
		JLabel productsLabel = new JLabel("Products", SwingConstants.CENTER);
		productsLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
		contentPane.add(productsLabel);
        
        // Add padding around the content. 
		contentPane.setBorder(new EmptyBorder(42, 120, 175, 120)); 
		
		JButton buttonViewProducts = new JButton("View Products");
		buttonViewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewProductsFrame();
			}
		});
		buttonViewProducts.setFont(new Font("SansSerif", Font.PLAIN, 14));
		contentPane.add(buttonViewProducts);
		
		JButton buttonUpdateStock = new JButton("Update Stock");
		buttonUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateProductStockFrame();
			}
		});
		buttonUpdateStock.setFont(new Font("SansSerif", Font.PLAIN, 14));
		contentPane.add(buttonUpdateStock);
		
		setVisible(true);
	}

}
