package com.intheeast.aspectj.combinedpointcut.aspect;

import static java.lang.System.out;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("com.intheeast.aspectj.combinedpointcut.pointcuts.CommonPointcuts.inWebLayer()"
			+ "&& execution(public * *(..))")
	public void publicWebLayerOperation() {}
	
	@Pointcut("com.intheeast.aspectj.combinedpointcut.pointcuts.CommonPointcuts.businessService()"
			+ "&& !com.intheeast.aspectj.combinedpointcut.pointcuts.CommonPointcuts.inDataAccessLayer()")
	public void transactionServiceOperation() {}
	
	@Pointcut("publicWebLayerOperation() || transactionServiceOperation() ")
	public void webOrTranscationalServiceOperation() {}
	
	// JoinPoint 인터페이스 name에 주의하자!!!
	// org.aopalliance.intercept 패키지의 Joinpoint와 혼동하지 말것!!!
	// 우리가 사용할 조인포인트는 org.aspectj.lang.JoinPoint 임!!!
	@Before("publicWebLayerOperation()")
	public void logBeforePublicWebOperation(JoinPoint joinpoint) {
		out.println("logBeforePublicWebOperation advice");
		out.println("Method: " + joinpoint.getSignature().getName());
	}
	
	@Before("transactionServiceOperation()")
	public void logBeforeTransactionalServiceOperation(JoinPoint joinpoint) {
		out.println("logBeforeTransactionalServiceOperation advice");
		out.println("Method: " + joinpoint.getSignature().getName());
	}
	
	@Before("webOrTranscationalServiceOperation()")
	public void logBeforeWebOrTransactionalOperation(JoinPoint joinpoint) {
		out.println("logBeforeWebOrTransactionalOperation advice");
		out.printf("Target Class:%s \n Method:%s \n", 
				joinpoint.getTarget().getClass().getName(), 
				joinpoint.getSignature().getName());
	}
	
	

}
