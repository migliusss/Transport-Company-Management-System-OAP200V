package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author 
 * This class represents order details in a system. 
 */

public class OrderDetails {
	private int orderNumber, quantityOrdered, orderLineNumber;
	private String productCode;
	private double priceEach;
	
	/**
	 * Constructor for creating order details. 
	 * 
	 * @param orderNumber        Order number. 
	 * @param productCode        Product code. 
	 * @param quantityOrdered    Quantity ordered of the product. 
	 * @param priceEach          Price of each order. 
	 * @param orderLineNumber    Order line number. 
	 */
	OrderDetails(int orderNumber, String productCode, int quantityOrdered, double priceEach, 
			int orderLineNumber) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}
}
