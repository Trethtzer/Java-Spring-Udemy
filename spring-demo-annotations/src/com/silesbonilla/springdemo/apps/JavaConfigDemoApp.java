package com.silesbonilla.springdemo.apps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.silesbonilla.springdemo.interfaces.Coach;
import com.silesbonilla.springdemo.utils.SpringConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Coach theCoach = context.getBean("footballCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();

	}

}
