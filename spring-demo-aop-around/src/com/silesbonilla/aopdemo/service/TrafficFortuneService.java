package com.silesbonilla.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	
	
	public TrafficFortuneService() {}
	
	
	public String getFortune(boolean b){
		
		if(b) {
			throw new RuntimeException("Majo accident! Highway is closed!");
		}
		
		try {
		TimeUnit.SECONDS.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Today is your daynight";
	}
}
