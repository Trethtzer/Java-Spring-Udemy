package com.silesbonilla.aopdemo.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	}
	
}
