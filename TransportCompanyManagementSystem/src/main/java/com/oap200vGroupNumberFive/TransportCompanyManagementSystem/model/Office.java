package com.oap200vGroupNumberFive.TransportCompanyManagementSystem.model;

/**
 * @author Migle Adomonyte
 * This class represent an office in the system. 
 */

public class Office {
	/**
	 * Static counter track the last assigned officeCode
	 */
	private static int lastOfficeCode; // HUSK: Må telle antall rader i offices tabellen. 

	private int officeCode;
	
	/**
	 * The phone number of the office. 
	 */
	private String phone;
	
	/**
	 * The territory of the office. 
	 */
	private String territory;
	
	/**
	 * The address of the office. 
	 */
	private Address address;
	
	/**
	 * Constructor for creating a new office. 
	 */
	Office() {
	}
	
	/**
	 * Constructor for creating a new office. 
	 * @param phone
	 * @param territory
	 * @param address
	 */
	Office(String phone, String territory, Address address) {
		lastOfficeCode++;
		
		this.officeCode = lastOfficeCode;
		this.phone = phone;
		this.territory = territory;
		this.address = address;
	}
	
	/**
	 * Getter for lastOfficeCode.
	 * @return lastOfficeCode
	 */
	public static int getLastOfficeCode() {
		return lastOfficeCode;
	}

	/**
	 * Setter for lastOfficeCode.
	 * @param lastOfficeCode
	 */
	public static void setLastOfficeCode(int lastOfficeCode) {
		Office.lastOfficeCode = lastOfficeCode;
	}

	/**
	 * Getter for officeCode.
	 * @return officeCode
	 */
	public int getOfficeCode() {
		return officeCode;
	}

	/**
	 * Setter for officeCode. 
	 * @param officeCode
	 */
	public void setOfficeCode(int officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 * Getter for phone. 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for phone.
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Getter for territory. 
	 * @return territory
	 */
	public String getTerritory() {
		return territory;
	}

	/**
	 * Setter for territory.
	 * @param territory
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}

	/**
	 * Getter for address. 
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Setter for address.
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * A method for displaying office information. 
	 */
	public void displayOfficeInfo () {
		System.out.println("Office Code: " + this.officeCode);
		System.out.println("Office Phone Number: "+ this.phone);
		System.out.println("Office Territory: " + this.territory);
		System.out.println("Office Address: " + this.address); 
	}
}
