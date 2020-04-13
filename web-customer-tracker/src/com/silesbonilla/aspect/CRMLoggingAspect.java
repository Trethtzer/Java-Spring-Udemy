package com.silesbonilla.aspect;

//import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	//private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.silesbonilla.controllers.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.silesbonilla.services.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.silesbonilla.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("BEFORE The method -----> " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for (Object tempArg : args) {
			System.out.println("Arguments ---> " + tempArg.toString());
		}
	}
	
	// add @After returning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("AFTER The method -----> " + theMethod);
		
		// display data returned	
		if (theResult != null) {
			System.out.println("Result ---> " + theResult.toString());
		}
	}
	
}
