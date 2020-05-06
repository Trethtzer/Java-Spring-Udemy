package com.silesbonilla.springbootdemo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// expose "/" that returns hello world
	@GetMapping("/")
	public String sayHello() {
		return "hello wolrd!!! Time on the server is: " + LocalDateTime.now();
	}
	
}
