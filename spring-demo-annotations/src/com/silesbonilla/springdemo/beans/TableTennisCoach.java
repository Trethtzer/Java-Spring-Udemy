package com.silesbonilla.springdemo.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.silesbonilla.springdemo.interfaces.Coach;
import com.silesbonilla.springdemo.interfaces.FortuneService;

@Component
@Scope("singleton")
public class TableTennisCoach implements Coach{
	
	private FortuneService myFortuneService;
	
	
	@Autowired
	public TableTennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		myFortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Tick tack propuesta";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return myFortuneService.getFortune();
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("Inside Post constructor method");
	}
	
	@PreDestroy
	public void onDestroyMethod() {
		System.out.println("Inside pre destruction method");
	}
	
}
