package com.silesbonilla.springdemo.apps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.silesbonilla.springdemo.interfaces.Coach;
import com.silesbonilla.springdemo.utils.SpringConfig;

public class BadukJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Coach theCoach = context.getBean("stupidCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();

	}

}
