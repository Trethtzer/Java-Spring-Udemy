package com.silesbonilla.services;

import java.util.List;

import com.silesbonilla.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
	public void deleteCustomer(int theId);
}
