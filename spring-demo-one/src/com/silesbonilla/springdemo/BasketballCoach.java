package com.silesbonilla.springdemo;

public class BasketballCoach implements Coach {
	private FortuneService fortuneService;
	
	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Jugar al basket hasta meterle una manita a Angel";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void onInitBean() {
		System.out.println("BasketballCoach: Hello there! I just arrived.");
	}
	public void onDestroyBean() {
		System.out.println("BasketballCoach: Hey, I'm leaving now, see you soon!");
	}

}
