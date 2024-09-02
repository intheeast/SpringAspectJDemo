package com.intheeast.aspectj.declaringadvice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Aspect("perthis(serviceMethods())")
@Component
@Scope("prototype")
public class LoggingAspectPerThis {

	private int executionCount = 0;
	
	@Pointcut("execution(* com.intheeast.aspectj.declaringadvice.service.SampleService.*(..))")
	public void serviceMethods() {}
	
	@Before("serviceMethods()")
	public void logExecution(JoinPoint jp) {
		executionCount++;
		System.out.println("*******************************************************");
		System.out.println(
				"Method: " + jp.getSignature().getName()
				+ ". executed: " + executionCount +
				" times for this instatnce");
		System.out.println("*******************************************************");
	}
}
