package com.silesbonilla.springdemo;

import org.springframework.stereotype.Component;

@Component
public class TableTennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Tick tack propuesta";
	}
	
	

}
