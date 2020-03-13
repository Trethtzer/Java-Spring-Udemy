package com.silesbonilla.springdemo.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotNull(message="First Name is required")
	@Size(min=1, message="First Name is required")
	private String firstName;
	
	@NotNull(message="Last Name is required")
	@Size(min=1, message="Last Name is required")
	private String lastName;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

}
