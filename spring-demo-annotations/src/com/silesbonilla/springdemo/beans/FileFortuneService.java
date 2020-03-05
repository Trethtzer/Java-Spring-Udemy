package com.silesbonilla.springdemo.beans;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.silesbonilla.springdemo.interfaces.FortuneService;

@Component
public class FileFortuneService implements FortuneService {

	@Value("#{'${fortunes}'.split(',')}")
	private String [] data;
	
	private String todaysLuck;
	
	
	@PostConstruct
	public void postCreate() {
		Random r = new Random();
		todaysLuck = data[r.nextInt(data.length)];
	}
	

	@Override
	public String getFortune() {
		Random r = new Random();
		return todaysLuck;
	}
}
