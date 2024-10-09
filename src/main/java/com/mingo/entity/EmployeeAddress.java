package com.mingo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeAddress {
	private String addressLine_1;
	private String addressLine_2;
	private String city;
	private String state;
	private String country;
	private int pinCode;
	
	public EmployeeAddress() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeAddress(String addressLine_1, String addressLine_2, String city, String state, String country,
			int pinCode) {
		super();
		this.addressLine_1 = addressLine_1;
		this.addressLine_2 = addressLine_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	public String getAddressLine_1() {
		return addressLine_1;
	}

	public void setAddressLine_1(String addressLine_1) {
		this.addressLine_1 = addressLine_1;
	}

	public String getAddressLine_2() {
		return addressLine_2;
	}

	public void setAddressLine_2(String addressLine_2) {
		this.addressLine_2 = addressLine_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
}
