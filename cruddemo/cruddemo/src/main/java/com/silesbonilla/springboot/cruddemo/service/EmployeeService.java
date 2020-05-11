package com.silesbonilla.springboot.cruddemo.service;

import java.util.List;

import com.silesbonilla.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
