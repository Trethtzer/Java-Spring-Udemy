package com.silesbonilla.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.silesbonilla.aopdemo.entity.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	
	
	public String getName() {
		System.out.println("inside getName getter method");
		return name;
	}
	public void setName(String name) {
		System.out.println("inside setName setter method");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("inside getService getter method");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println("inside setService setter method");
		this.serviceCode = serviceCode;
	}

	
	
	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
