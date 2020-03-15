package com.silesbonilla.springdemo.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.silesbonilla.springdemo.utils.CourseCode;

public class Customer {
	
	@NotNull(message="First Name is required")
	@Size(min=1, message="First Name is required")
	private String firstName;
	
	@NotNull(message="Last Name is required")
	@Size(min=1, message="Last Name is required")
	private String lastName;

	@NotNull(message="A number is required")
	@Min(value=0,message="must be greater than or equal to zero")
	@Max(value=10,message="must be less than or equal to ten")
	private Integer freePass;
	
	@Pattern(regexp = "[a-zA-Z0-9]{5}", message="only 5 charts/digits")
	private String postalCode;
	
	@CourseCode(value="TOPS", message="Must start with TOPS")
	private String courseCode;
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getFreePass() {
		return freePass;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFreePass(Integer freePass) {
		this.freePass = freePass;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
