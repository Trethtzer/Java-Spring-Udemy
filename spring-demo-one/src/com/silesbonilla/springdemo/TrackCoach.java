package com.silesbonilla.springdemo;

public class TrackCoach implements Coach {
private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run until you can't continue, then run more";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
