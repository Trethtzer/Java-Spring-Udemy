package com.silesbonilla.springdemo.beans;

import org.springframework.stereotype.Component;

import com.silesbonilla.springdemo.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is not your lucky day";
	}

}
