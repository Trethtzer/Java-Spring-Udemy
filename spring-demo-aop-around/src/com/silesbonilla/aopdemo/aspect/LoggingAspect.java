package com.silesbonilla.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.silesbonilla.aopdemo.entity.Account;

@Aspect
@Component
@Order(0)
public class LoggingAspect{
	
	private Logger myLogger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Before("com.silesbonilla.aopdemo.aspect.MyPointcuts.forDaoPackageWithoutGetsSets()")
	public void beforeAddAccountAdvice(JoinPoint joinpoint) {
		myLogger.info("STANDARD BEFORE!!!");
		
		// display the method signature
		myLogger.info("Method sig:" + joinpoint.getSignature());
		
		// display the method arguments
		for (Object o : joinpoint.getArgs()) {
			myLogger.info(o.toString());
		}
	}
	
	@AfterReturning(
			pointcut="execution(* com.silesbonilla.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)	
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {		
		
		for(Account a : result) {
			a.setLevel(a.getLevel().toUpperCase());
			a.setName(a.getName().toUpperCase());			
		}
		
		myLogger.info("End of RETURNING advice");
	}
	
	@AfterThrowing(
			pointcut="execution(* com.silesbonilla.aopdemo..*(..))",
			throwing="e"
			)
	public void afterThrowingExceptions(JoinPoint theJoinPoint,Exception e) {
		
		myLogger.info("Method sig:" + theJoinPoint.getSignature());
		myLogger.info("The exception is: " + e.toString());
		myLogger.info("End of THROWING advice");
	}
	
	@After("execution(* com.silesbonilla.aopdemo..*(..))")	
	public void afterFinally(JoinPoint theJoinPoint) {
		
		myLogger.info("Method sig:" + theJoinPoint.getSignature());
		myLogger.info("Method ended ");
		myLogger.info("End of FINALLY advice");
	}
	
	@Around("execution(* com.silesbonilla.aopdemo..*(..))")
	public Object aroundGeneralAdvice(ProceedingJoinPoint theProceedingJoinPoint) {
		myLogger.info("Executing around method");
		
		Object result = new Object();
		
		long begin = System.currentTimeMillis();
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			
			// result = "Major accident! But an helicopter is on the way :)";
			
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("Around advice: Time to execute the method -> " + duration + "miliseconds");
		
		return result;
	}
	
}
