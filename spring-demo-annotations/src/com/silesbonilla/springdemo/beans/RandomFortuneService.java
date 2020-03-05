package com.silesbonilla.springdemo.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.silesbonilla.springdemo.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
		"Yep, try again until you make it"
		, "Be ware of the boogeyman"
		, "Not the day to travel man"
	};

	@Override
	public String getFortune() {
		Random r = new Random();
		return data[r.nextInt(data.length)];
	}

}
