package com.silesbonilla.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class LoggingAspectDuplicate {
	
	@Before("com.silesbonilla.aopdemo.aspect.MyPointcuts.forDaoPackageWithoutGetsSets()")
	public void performAPIAnalytics() {
		System.out.println("API!!!!!");
	}
	
}
