package com.silesbonilla.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LoggingAspect{
	
	@Before("com.silesbonilla.aopdemo.aspect.MyPointcuts.forDaoPackageWithoutGetsSets()")
	public void beforeAddAccountAdvice(JoinPoint joinpoint) {
		System.out.println("STANDARD BEFORE!!!");
		
		// display the method signature
		System.out.println("Method sig:" + joinpoint.getSignature());
		
		// display the method arguments
		for (Object o : joinpoint.getArgs()) {
			System.out.println(o.toString());
		}
	}
	
}
