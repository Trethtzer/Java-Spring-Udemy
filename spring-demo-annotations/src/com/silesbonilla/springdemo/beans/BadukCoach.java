package com.silesbonilla.springdemo.beans;

import com.silesbonilla.springdemo.interfaces.Coach;
import com.silesbonilla.springdemo.interfaces.FortuneService;

public class BadukCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BadukCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "one game, 2 hours of problems, one lecture of in-seong";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
