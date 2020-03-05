package com.silesbonilla.springdemo.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.silesbonilla.springdemo.interfaces.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tableTennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tableTennisCoach", Coach.class);
		
		System.out.println("Are theCoach and alphaCoach the same Coach???");
		if (theCoach == alphaCoach) {
			System.out.println("Yes!!!");
		}else {
			System.out.println("no :(");
		}

		context.close();
	}

}
