package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author 
 * This class represents a product line in the system. 
 */

public class ProductLine {
	private String productLine, textDescription, htmlDescription, image;
	
	/**
	 * Constructor for creating a new product line. 
	 * 
	 * @param productLine        Product line. 
	 * @param textDescription    Text description. 
	 * @param htmlDescription    HTML description. 
	 * @param image              Image. 
	 */
	ProductLine(String productLine, String textDescription, String htmlDescription, String image) {
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
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
	 * Getter for text description. 
	 * @return Text description. 
	 */
	public String getTextDescription() {
		return textDescription;
	}

	/**
	 * Setter for text description. 
	 * @param textDescription Text description to set. 
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	/**
	 * Getter for HTML description. 
	 * @return HTML description. 
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}

	/**
	 * Setter for HTML description. 
	 * @param htmlDescription HTML description to set. 
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	/**
	 * Getter for image. 
	 * @return Image. 
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Setter for image. 
	 * @param image Image to set. 
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
