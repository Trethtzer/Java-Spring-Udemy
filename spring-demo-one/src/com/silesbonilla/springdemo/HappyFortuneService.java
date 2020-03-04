package com.silesbonilla.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today you will get 6s in your dices";
	}

}
