package com.silesbonilla.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.silesbonilla.aopdemo.entity.Account;

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
	
	@AfterReturning(
			pointcut="execution(* com.silesbonilla.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)	
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {		
		
		for(Account a : result) {
			a.setLevel(a.getLevel().toUpperCase());
			a.setName(a.getName().toUpperCase());			
		}
		
		System.out.println("End of RETURNING advice");
	}
	
	@AfterThrowing(
			pointcut="execution(* com.silesbonilla.aopdemo..*(..))",
			throwing="e"
			)
	public void afterThrowingExceptions(JoinPoint theJoinPoint,Exception e) {
		
		System.out.println("Method sig:" + theJoinPoint.getSignature());
		System.out.println("The exception is: " + e.toString());
		System.out.println("End of THROWING advice");
	}
	
	@After("execution(* com.silesbonilla.aopdemo..*(..))")	
	public void afterFinally(JoinPoint theJoinPoint) {
		
		System.out.println("Method sig:" + theJoinPoint.getSignature());
		System.out.println("Method ended ");
		System.out.println("End of FINALLY advice");
	}
	
}
