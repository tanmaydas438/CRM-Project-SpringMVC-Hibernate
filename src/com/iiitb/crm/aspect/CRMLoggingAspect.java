package com.iiitb.crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.iiitb.crm.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.iiitb.crm.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("execution(* com.iiitb.crm.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint jp)
	{
		String methodName=jp.getSignature().getName();
		myLogger.info("====> I am In @ before Aspect, Method:"+methodName);
		Object[] args=jp.getArgs();
		for(Object obj:args)
			System.out.println(obj);
	}
	
}
