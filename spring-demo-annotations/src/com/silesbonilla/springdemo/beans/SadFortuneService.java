package com.silesbonilla.springdemo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.silesbonilla.springdemo.interfaces.FortuneService;

public class SadFortuneService implements FortuneService{
	
	@Value("${sad.fortune}")
	private String todaySadFortune;

	
	public String getTodaySadFortune() {
		return todaySadFortune;
	}
	
	
	@Override
	public String getFortune() {
		return todaySadFortune;
	}
	
	
	

}
