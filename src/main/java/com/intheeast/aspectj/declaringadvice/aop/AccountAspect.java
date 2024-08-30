package com.intheeast.aspectj.declaringadvice.aop;

import static java.lang.System.out;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

	@Around(
			"execution(java.util.List<com.intheeast.aspectj.declaringadvice.model.Account> " +
			"com.intheeast.aspectj.declaringadvice.service.AccountService.find*(..)) " +
			"&& com.intheeast.aspectj.declaringadvice.aspect.CommonPointcuts.inDataAccessLayer()" +
			" && " + "args(accountHolderNamePattern)"			
			)
	public Object preProcessingQureryPattern(ProceedingJoinPoint pj,
			String accountHolderNamePattern) throws Throwable {
		out.println("preProcessingQureryPattern Advice");
		out.println("Class: " + pj.getTarget().getClass().getName());
		out.println("Method: " + pj.getSignature().getName());		
//		Object ret = pj.proceed(); // ->...이렇게 사용하면 되는데,,,		
		String newPattern = preProcess(accountHolderNamePattern);
		
		return pj.proceed(new Object[] {newPattern});
	}
	
	private String preProcess(String pattern) {
		return pattern.toUpperCase();
	}
	
}
