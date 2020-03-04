package com.silesbonilla.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String email;
	private String teamName;
	
	
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println("Inside setter method -setEmail");
		this.email = email;
	}

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		System.out.println("Inside setter method -setTeamName");
		this.teamName = teamName;
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method -setFortuneService");
		this.fortuneService = fortuneService;
	}

	
	
	@Override
	public String getDailyWorkout() {
		return "Just sit and eat, this sport is shit";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
