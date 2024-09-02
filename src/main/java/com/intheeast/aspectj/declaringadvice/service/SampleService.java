package com.intheeast.aspectj.declaringadvice.service;

import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.intheeast.aspectj.declaringadvice.annotation.AuditCode;
import com.intheeast.aspectj.declaringadvice.annotation.AuditableCode;
import com.intheeast.aspectj.declaringadvice.model.MyType;

@Service
@Scope("prototype")
public class SampleService implements Sample<MyType> {

	@AuditableCode(AuditCode.USER_ACTION)
	public void sampleMethod(String data) {
		System.out.println("Executing sampleMethod with data: " + data);
	}
	
	@Override
	public void sampleGenericMethod(MyType sampleGenericParam) {
		System.out.println("Executing sampleGenericMethod called with param: " + sampleGenericParam);
		
	}

	@Override
	public void sampleGenericCollectionMethod(Collection<MyType> param) {
		System.out.println("Executing sampleGenericCollectionMethod called with param: " + param);
		
	}
	
	

}
