package com.silesbonilla.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.silesbonilla.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData(){
		Employee emp = new Employee(1, "Leslie", "Andrews", "leslie@comillo.com");
		Employee emp1 = new Employee(1, "Yorick", "El enterrador", "yorick@comillo.com");
		Employee emp2 = new Employee(1, "Nasus", "anubis", "egipt@comillo.com");
		Employee emp3 = new Employee(1, "Garen", "Caballero", "roca@comillo.com");
		
		theEmployees = new ArrayList<>();
		
		theEmployees.add(emp);
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
