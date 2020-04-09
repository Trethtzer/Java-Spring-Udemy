package com.silesbonilla.aopdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.silesbonilla.aopdemo.DemoConfig;
import com.silesbonilla.aopdemo.service.TrafficFortuneService;

public class MainDemoAppHandleExceptions {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
				
		TrafficFortuneService tfs = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println(tfs.getFortune(true));
		
		context.close();

	}

}
