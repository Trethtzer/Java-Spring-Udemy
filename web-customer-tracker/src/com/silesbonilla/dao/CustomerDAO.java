package com.silesbonilla.dao;

import java.util.List;

import com.silesbonilla.entities.Customer;

public interface CustomerDAO {

	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int theId);
}
