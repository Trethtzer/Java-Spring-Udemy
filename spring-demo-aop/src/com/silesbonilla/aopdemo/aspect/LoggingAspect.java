package com.silesbonilla.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* add*(com.silesbonilla.aopdemo.entity.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @before advice on addacount()");
	}
	
}
