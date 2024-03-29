package com.silesbonilla.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public List<Account> findAccounts(boolean tripWare) {
		
		if (tripWare) {
			throw new RuntimeException("No soup for anyone..");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account theAccount1 = new Account("Pepe", "Antonio");
		Account theAccount2 = new Account("Jonnhy", "Kachanovsky");
		Account theAccount3 = new Account("Lucas", "Duck");
		
		myAccounts.add(theAccount1);
		myAccounts.add(theAccount2);
		myAccounts.add(theAccount3);
		
		return myAccounts;
	}
}
