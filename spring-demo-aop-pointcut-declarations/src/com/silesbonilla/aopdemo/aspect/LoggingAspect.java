package com.silesbonilla.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.silesbonilla.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}

	@Pointcut("execution(* com.silesbonilla.aopdemo.dao.*.get*(..))")
	public void forDaoPackageGets() {}
	
	@Pointcut("execution(* com.silesbonilla.aopdemo.dao.*.set*(..))")
	public void forDaoPackageSets() {}
	
	@Pointcut("forDaoPackage() && !(forDaoPackageGets() || forDaoPackageSets())")
	public void forDaoPackageWithoutGetsSets() {}
	
	@Before("forDaoPackageWithoutGetsSets()")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @before advice on dao package");
	}
	@Before("forDaoPackageWithoutGetsSets()")
	public void performAPIAnalytics() {
		System.out.println("Executing @before advice analytics on dao package");
	}
	
}
