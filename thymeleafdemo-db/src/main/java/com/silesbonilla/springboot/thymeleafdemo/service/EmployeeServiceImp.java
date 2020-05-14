package com.silesbonilla.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silesbonilla.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.silesbonilla.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeRepository employeeRep;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository theEmployeeRep) {
		employeeRep = theEmployeeRep;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRep.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRep.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee with id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRep.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRep.deleteById(theId);
	}

}
