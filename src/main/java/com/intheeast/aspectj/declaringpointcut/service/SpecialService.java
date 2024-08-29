package com.intheeast.aspectj.declaringpointcut.service;

import com.intheeast.aspectj.declaringpointcut.annotation.Loggable;
import com.intheeast.aspectj.declaringpointcut.annotation.SpecialComponent;
import com.intheeast.aspectj.declaringpointcut.annotation.Validated;

@SpecialComponent
public class SpecialService {
	
	@Loggable
	public void specialOperation(String operation) {
		System.out.println("*******************************************************");
		System.out.println("Performing special operation: " + operation);
		System.out.println("*******************************************************");
	}
	
	public void anotherSpecialOperation(@Validated String parameter) {
		System.out.println("*******************************************************");
		System.out.println("Performing another special operation: " + parameter);
		System.out.println("*******************************************************");
	}

}
