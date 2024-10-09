package com.mingo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeName {
	
	private String firstName;
	private String lastName;
	
	public EmployeeName() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}
	
	

	public EmployeeName(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
