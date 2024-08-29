package com.intheeast.aspectj.declaringpointcut.aspect;

import static java.lang.System.out;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component  // 이 어노테이션이 적용된 클래스는 Spring Ioc에 의해 객체로 만들어져서 빈으로 등록된다.
public class LoggingAspect {
	/*
	// 특정 메서드 이름[예, tranfer 메서드]을 매칭하는 포인트컷
	@Pointcut("execution(* transfer(..))")
	private void anyTransferOperation() {}
	
	// TransferService 클래스내의 모든 메서드를 매칭하는 포인트컷
	@Pointcut("within(com.intheeast.aspectj.declaringpointcut.service.TransferService)")
	private void withinTransferService() {}
	
	// this pcd를 사용하여 프록시 객체의 타입에 따라 매칭
	@Pointcut("this(com.intheeast.aspectj.declaringpointcut.service.TransferService)")
	private void proxyIsTransferService() {}
	
	// target pcd를 사용하여 실제 타겟 객체의 타입에 따라 매칭
	@Pointcut("target(com.intheeast.aspectj.declaringpointcut.service.SpecialService)")
	private void targetIsSpecialService() {}
	
	// args 디지그네이터를 사용하여 메서드의 아규먼트가 특정 타입인 경우 매칭
	@Pointcut("args(String, ..)")
	private void methodWithStringArg() {}
	
	// @annotation 디지그네이터를 사용하여 메서드에 특정 어노테이션이 있는 경우 매칭
	@Pointcut("@annotation(com.intheeast.aspectj.declaringpointcut.annotation.Loggable)")
	private void loggableMethods() {}
	
	
	// @within 디지그네이터를 사용하여 클래스에 특정 어노테이션이 붙어 있는 경우 매칭
	@Pointcut("@within(com.intheeast.aspectj.declaringpointcut.annotation.SpecialComponent)")
	private void withinSpecialComponent() {}
	
	// @target 디지그네이터를 사용하여 실제 객체가 특정 어노테이션을 가지고 있는 경우에 매칭
	@Pointcut("@target(com.intheeast.aspectj.declaringpointcut.annotation.SpecialComponent)")
	private void targetHasSpecialComponet() {}
	*/
	
	// @args 디지그네이터를 사용하여 메서드의 아규먼트[파라미터]가 특정 어노테이션을 가진 타입인 경우에 매칭
	@Pointcut("@args(com.intheeast.aspectj.declaringpointcut.annotation.Validated)")
	private void methodWithValidatedArgs() {}
	// Advice 구현
	////////////////////////////////////////////////////////////////////
	/*
	@Before("anyTransferOperation()") 
	public void logBeforeTransfer(){
		out.println("logBeforeTransfer");
		out.println("-----------------------------------------------------------------------------");
	}
	
	@Before("withinTransferService()")
	public void logBeforeWithinTransferService(JoinPoint joinpoint) {
		out.println("logBeforeWithinTransferService");
		Object proxy = joinpoint.getThis();
		out.println("Proxy class: " + proxy.getClass().getName());
		out.println("Method: " + joinpoint.getSignature().getName());
		out.println("Target object: " + joinpoint.getTarget());	
		out.println("-----------------------------------------------------------------------------");
	}
	
	// Transfer 타입의 프록시가 사용될 때, 
	// 프록시 클래스 이름과 호출되는 메서드 이름을 로그로 출력합니다.
	@Before("proxyIsTransferService()")
	public void logWhenProxyIsTransferService(JoinPoint joinpoint) {
		Object proxy = joinpoint.getThis();
		out.println("Logging when proxy is of type TransferService");
		out.println("Proxy class: " + proxy.getClass().getName());
		out.println("-----------------------------------------------------------------------------");
	}
	
	@Before("targetIsSpecialService()")
	public void logWhenTargetIsSpecialService(JoinPoint joinpoint) {
		out.println("Logging when target is of type SpecialService");
		out.println("Target class: " + joinpoint.getTarget().getClass().getName());
		out.println("Method being called: " + joinpoint.getSignature().getName());
		out.println("-----------------------------------------------------------------------------");
	}
	
	@Before("methodWithStringArg()")
	public void logForMethodsWithStringArg(JoinPoint joinpoint) {
		out.println("Logging method with String argument");
		out.println("Method being called: " + joinpoint.getSignature().getName());
		out.println("Arguments: " + Arrays.toString(joinpoint.getArgs())); 
		out.println("-----------------------------------------------------------------------------");
	}
	
	
	// @Loggable 어노테이션이 붙은 메서드가 호출될 때, 메서드 이름과 타겟 클래스 정보를 로그로 출력.
	@Before("loggableMethods()")
	public void logForLoggableMethods(JoinPoint joinpoint) {
		out.println("Logging for method annotated with @Loggable");
		out.println("Method: " + joinpoint.getSignature().getName());
		out.println("Target class: " + joinpoint.getTarget().getClass().getName()); 
		out.println("-----------------------------------------------------------------------------");
	}
		
	// @SpecialComponent 어노테이션이 붙은 클래스 내의 메서드가 호출될 때,
	// 메서드 이름과 클래스 이름을 로그로 출력
	@Before("withinSpecialComponent()")
	public void logWithinSpecialComponet(JoinPoint joinpoint) {
		out.println("Logging for methods within a @SpecialComponent class");
		out.println("Method: " + joinpoint.getSignature().getName());
		out.println("Class: " + joinpoint.getTarget().getClass().getName()); 
		out.println("-----------------------------------------------------------------------------");
	}
	
	
	@Before("targetHasSpecialComponet()") 
	public void logWhenTargetHasSpecialComponent(JoinPoint joinpoint){
		out.println("Logging for targets annotated with @SpecialComponent class");
		out.println("Target Class: " + joinpoint.getTarget().getClass().getName()); 
		out.println("Method being called: " + joinpoint.getSignature().getName());		
		out.println("-----------------------------------------------------------------------------");
	}
	*/
	
	@After("methodWithValidatedArgs()")
	public void logForMethodsWithValidatedArgs(JoinPoint joinpoint){
		out.println("Logging for methods with @Validated annotated arguments");
		out.println("Method: " + joinpoint.getSignature().getName());	
		out.println("Arguments: " + Arrays.toString(joinpoint.getArgs()));
		out.println("-----------------------------------------------------------------------------");
	}
	
	
}
