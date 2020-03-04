package com.silesbonilla.springdemo;

public class BaseballCoach implements Coach{
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes doing jumping jacks";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
