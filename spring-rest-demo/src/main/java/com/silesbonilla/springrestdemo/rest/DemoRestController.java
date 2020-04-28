package com.silesbonilla.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silesbonilla.springrestdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	// add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "hello boyzz";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Ben", "Hanscom"));
		students.add(new Student("Bill", "Denbrough"));
		students.add(new Student("Beverly", "Hill"));
		students.add(new Student("Richie", "Tozier"));
		
		return students;
	}
}
