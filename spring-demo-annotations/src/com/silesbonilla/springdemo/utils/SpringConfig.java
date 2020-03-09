package com.silesbonilla.springdemo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.silesbonilla.springdemo.beans.BadukCoach;
import com.silesbonilla.springdemo.beans.SadFortuneService;
import com.silesbonilla.springdemo.beans.StupidCoach;
import com.silesbonilla.springdemo.interfaces.FortuneService;

@Configuration
//@ComponentScan("com.silesbonilla.springdemo.beans")
@PropertySource("classpath:fortunes.properties")
public class SpringConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public BadukCoach badukCoach() {
		return new BadukCoach(sadFortuneService());
	}
	
	@Bean
	public StupidCoach stupidCoach() {
		return new StupidCoach();
	}
}
