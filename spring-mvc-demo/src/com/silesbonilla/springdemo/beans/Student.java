package com.silesbonilla.springdemo.beans;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	private String favouriteLanguage;
	
	private String[] operatingSystems;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("ES", "Spain");
		countryOptions.put("GB", "Britain");
		countryOptions.put("FR", "France");
		countryOptions.put("US", "United States");
		countryOptions.put("SK", "South Korea");
		countryOptions.put("JP", "Japan");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCountry() {
		return country;
	}
	public LinkedHashMap<String, String> getCountryOptions(){
		return countryOptions;
	}
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;				
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}
	public void setOperatingSystems(String [] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
