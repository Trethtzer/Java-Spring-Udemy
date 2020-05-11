package com.silesbonilla.springbootdemo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coach;
	@Value("${team.name}")
	private String teamName;
	
	// expose new endpoint for teaminfo
	@GetMapping("/team")
	public String team() {
		return "Coach name: " + coach + ", Team name: " + teamName;
	}
	
	// expose "/" that returns hello world
	@GetMapping("/")
	public String sayHello() {
		return "hello wolrd!!! Time on the server is: " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day";
	}
}
