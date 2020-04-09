package com.silesbonilla.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyPointcuts {
	@Pointcut("execution(* com.silesbonilla.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}

	@Pointcut("execution(* com.silesbonilla.aopdemo.dao.*.get*(..))")
	public void forDaoPackageGets() {}
	
	@Pointcut("execution(* com.silesbonilla.aopdemo.dao.*.set*(..))")
	public void forDaoPackageSets() {}
	
	@Pointcut("forDaoPackage() && !(forDaoPackageGets() || forDaoPackageSets())")
	public void forDaoPackageWithoutGetsSets() {}
}
