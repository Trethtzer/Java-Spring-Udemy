package com.silesbonilla.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silesbonilla.springrestdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load teh student data .. .only once!
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Ben", "Hanscom"));
		theStudents.add(new Student("Bill", "Denbrough"));
		theStudents.add(new Student("Beverly", "Hill"));
		theStudents.add(new Student("Richie", "Tozier"));
	}
	
	// add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "hello boyzz";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {		
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentid}")
	public Student getStudent(@PathVariable int studentid) {
		
		if (studentid >= theStudents.size() || studentid < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentid);
		}
		
		return theStudents.get(studentid);
	}
	
	
	
	
	
}
