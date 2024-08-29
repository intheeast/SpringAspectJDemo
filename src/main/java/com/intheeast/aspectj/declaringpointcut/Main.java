package com.intheeast.aspectj.declaringpointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectj.declaringpointcut.aspect.LoggingAspect;
import com.intheeast.aspectj.declaringpointcut.config.AppConfig;
import com.intheeast.aspectj.declaringpointcut.service.SpecialService;
import com.intheeast.aspectj.declaringpointcut.service.TransferService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		AppConfig config = (AppConfig) context.getBean("appConfig");
		LoggingAspect logAspect = (LoggingAspect) context.getBean("loggingAspect");
		
		TransferService transferService = 
				(TransferService) context.getBean("transferService");//TransferService
		
		transferService.transfer("12345", 10000);
		transferService.checkBalance();
		
		SpecialService specialferService = 
				(SpecialService) context.getBean("specialService");
		
		specialferService.specialOperation("Hi");
		specialferService.anotherSpecialOperation("GoodBye");
	}

}
