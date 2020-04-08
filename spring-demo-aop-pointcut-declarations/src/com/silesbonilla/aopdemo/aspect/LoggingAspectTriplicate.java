package com.silesbonilla.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(200)
public class LoggingAspectTriplicate {
	
	@Before("com.silesbonilla.aopdemo.aspect.MyPointcuts.forDaoPackageWithoutGetsSets()")
	public void beforeDoSomeLoggings() {
		System.out.println("LOGGINGS!!!!");
	}
	
}
