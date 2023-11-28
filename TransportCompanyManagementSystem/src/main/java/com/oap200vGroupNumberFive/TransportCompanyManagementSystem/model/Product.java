package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author 
 * This class represents a product  in the system. 
 */ 

public class Product {
	private int quantityInStock;
	private String productCode, productName, productLine, productScale, productVendor, productDescription;
	private float buyPrice, MSRP;
	
	/**
	 * Constructor for creating a new product. 
	 * 
	 * @param productCode           Product code. 
	 * @param productName           Product name. 
	 * @param productLine           Product line. 
	 * @param productScale          Product scale. 
	 * @param productVendor         Product vendor. 
	 * @param productDescription    Product description. 
	 * @param quantityInStock       Quantity in stock. 
	 * @param buyPrice              Buy price. 
	 * @param MSRP                  Manufacturer's suggested retail price. 
	 */
	public Product(String productCode, String productName, String productLine, String productScale, 
			String productVendor, String productDescription, int quantityInStock, float buyPrice, 
			float MSRP) {
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = MSRP;
	}

	/**
	 * Getter for product code. 
	 * @return Product code. 
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Setter for product code. 
	 * @param productCode Product code to set. 
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * Getter for product name. 
	 * @return Product name. 
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter for product name. 
	 * @param productName Product name to set. 
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Getter for product line. 
	 * @return Product line. 
	 */
	public String getProductLine() {
		return productLine;
	}

	/**
	 * Setter for product line. 
	 * @param productLine Product line to set. 
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	/**
	 * Getter for product scale. 
	 * @return Product scale. 
	 */
	public String getProductScale() {
		return productScale;
	}

	/**
	 * Setter for product scale. 
	 * @param productScale Product scale to set. 
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	/**
	 * Getter for product vendor. 
	 * @return Product vendor. 
	 */
	public String getProductVendor() {
		return productVendor;
	}

	/**
	 * Setter for product vendor. 
	 * @param productVendor Product vendor to set. 
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	/**
	 * Getter for product description. 
	 * @return Product description. 
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Setter for product description. 
	 * @param productDescription Product description to set. 
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	/**
	 * Getter for quantity in stock. 
	 * @return Quantity in stock. 
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * Setter for quantity in stock. 
	 * @param quantityInStock Quantity in stock to set. 
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * Getter for buy price. 
	 * @return Buy price. 
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * Setter for buy price. 
	 * @param buyPrice Buy price to set. 
	 */
	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * Getter for manufacturer's suggested retail price. 
	 * @return Manufacturer's suggested retail price. 
	 */
	public double getMSRP() {
		return MSRP;
	}

	/**
	 * Setter for manufacturer's suggested retail price. 
	 * @param MSRP Manufacturer's suggested retail price to set. 
	 */
	public void setMSRP(float MSRP) {
		this.MSRP = MSRP;
	}
	
	
}
