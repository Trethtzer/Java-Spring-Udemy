package com.silesbonilla.springdemo;

import org.springframework.stereotype.Component;

@Component()
public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {		
		return "Train your shoot, because you will have only few chances for scoring a goal";
	}

}
