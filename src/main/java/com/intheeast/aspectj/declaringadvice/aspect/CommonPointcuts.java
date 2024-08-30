package com.intheeast.aspectj.declaringadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {
	
	@Pointcut("within(com.intheeast.aspectj.declaringadvice.service..*)")
	public void inDataAccessLayer() {
		
	}

}
