package com.silesbonilla.springdemo.beans;

import org.springframework.beans.factory.annotation.Value;

import com.silesbonilla.springdemo.interfaces.Coach;

public class StupidCoach implements Coach {
	
	@Value("${stupidFortune}")
	private String fortuna;
	
	@Override
	public String getDailyWorkout() {
		return "Ehmmm..... mmm.... yeah... I forgot lol";
	}

	@Override
	public String getDailyFortune() {
		return fortuna;
	}

}
