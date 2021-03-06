package com.silesbonilla.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach secondaryCoach = context.getBean("myCoach",Coach.class);
		
		// Do stuff
		boolean result = theCoach == secondaryCoach;
		System.out.println("Are the same object? " + result);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for secondaryCoach: " + secondaryCoach);
		
		context.close();
	}

}
