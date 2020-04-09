package com.silesbonilla.aopdemo.main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.silesbonilla.aopdemo.DemoConfig;
import com.silesbonilla.aopdemo.service.TrafficFortuneService;

public class MainDemoAppAroundWithLogger {

	private static Logger myLogger = Logger.getLogger(MainDemoAppAroundWithLogger.class.getName());
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
				
		TrafficFortuneService tfs = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info(tfs.getFortune(false));
		
		context.close();

	}

}
