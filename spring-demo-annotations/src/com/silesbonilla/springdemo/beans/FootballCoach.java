package com.silesbonilla.springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.silesbonilla.springdemo.interfaces.Coach;
import com.silesbonilla.springdemo.interfaces.FortuneService;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	
	public FootballCoach() {
		System.out.println("FootballCoach: Inside constructor.");
	}
	
	
	@Override
	public String getDailyWorkout() {		
		return "Train your shoot, because you will have only few chances for scoring a goal";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	/*
	@Autowired
	public void randomMethodName(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
}
