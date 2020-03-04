package com.silesbonilla.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private String [] fortunes = new String[3];
	
	private String fortune1;
	private String fortune2;
	private String fortune3;
	
	@Override
	public String getFortune() {
		fortunes[0] = fortune1;
		fortunes[1] = fortune2;
		fortunes[2] = fortune3;
		
		Random r = new Random();
		return fortunes[r.nextInt(3)];
	}

	
	
	public String getFortune1() {
		return fortune1;
	}
	public void setFortune1(String fortune1) {
		this.fortune1 = fortune1;
	}

	public String getFortune2() {
		return fortune2;
	}
	public void setFortune2(String fortune2) {
		this.fortune2 = fortune2;
	}

	public String getFortune3() {
		return fortune3;
	}
	public void setFortune3(String fortune3) {
		this.fortune3 = fortune3;
	}

}
