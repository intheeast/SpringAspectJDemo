package com.intheeast.aspectj.declaringadvice;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectj.declaringadvice.aop.ExecutionCountingAspect;
import com.intheeast.aspectj.declaringadvice.config.AppConfig;
import com.intheeast.aspectj.declaringadvice.dao.AccountDao;
import com.intheeast.aspectj.declaringadvice.model.Account;
import com.intheeast.aspectj.declaringadvice.model.MyType;
import com.intheeast.aspectj.declaringadvice.model.UsageTracked;
import com.intheeast.aspectj.declaringadvice.service.AccountService;
import com.intheeast.aspectj.declaringadvice.service.AccountServiceImpl;
import com.intheeast.aspectj.declaringadvice.service.MyService;
import com.intheeast.aspectj.declaringadvice.service.SampleService;

public class Main {
	
	public static void checkAroundAdviceThroughAccountAccountService(
			ApplicationContext context) {
		AccountDao dao = 
				context.getBean(AccountDao.class);
		
		AccountService accountService = 
				context.getBean(AccountService.class);
		
		MyService myService = 
				(MyService) context.getBean("myService");
		myService.helloWorld("you");
		myService.performTask("hello");
		
		Account validAccount = new Account();
		validAccount.setId("12345");
		validAccount.setOwnerName("Sungwon Seo");
		validAccount.setBalance(1000.0);
		
		accountService.updateAccount(validAccount);
		
		List<Account> accounts1 = accountService.findAccounts("hello world");
		List<Account> accounts2 = accountService.findAccountName(validAccount);
	}
	
	public static void checkAfterThrowingAdviceThroughAccountAccountService(
			ApplicationContext context) {
		AccountDao dao = 
				context.getBean(AccountDao.class);
		
		AccountService accountService = 
				context.getBean(AccountService.class);
		
		Account validAccount = new Account();
		validAccount.setId("12345");
		validAccount.setOwnerName("Sungwon Seo");
		validAccount.setBalance(1000.0);
		
		accountService.updateAccount(validAccount);
		
		validAccount.setBalance(-5000.0);
				
		try {
			accountService.updateAccount(validAccount);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception Occurrence!!!");
			e.printStackTrace();
		}
		
	}
	
	public static void checkAroundAfterFinallyAccountAccountService(
			ApplicationContext context) {
		AccountDao dao = 
				context.getBean(AccountDao.class);
		
		AccountService accountService = 
				context.getBean(AccountService.class);
		
		Account validAccount = new Account();
		validAccount.setId("12345");
		validAccount.setOwnerName("Sungwon Seo");
		validAccount.setBalance(1000.0);
		
		accountService.updateAccount(validAccount);
		
		List<Account> accounts1 = accountService.findAccounts("hello world");
		List<Account> accounts2 = accountService.findAccountName(validAccount);
		
		MyService myService = 
				(MyService) context.getBean("myService");
		myService.performTask("hello");
	}
	
	public static void adviceParametersAndGenerics(
			ApplicationContext context) {
		
		SampleService sampleService = 
				(SampleService) context.getBean("sampleService");
		
		MyType myTypeInstance = new MyType("ExampleName");
		
		sampleService.sampleMethod("hello");
		
		sampleService.sampleGenericMethod(myTypeInstance);
		
		sampleService.sampleGenericCollectionMethod(Arrays.asList(myTypeInstance));
		
	}
	
	public static void checkAutomicThreadSafe(
			ApplicationContext context) {
	
		MyService myService = 
				context.getBean(MyService.class);
		
		Runnable task = () -> myService.performTask("hello");
		
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		Thread thread4 = new Thread(task);
		Thread thread5 = new Thread(task);
		
		// start가 Runnable의 run을 메서드를 호출
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		ExecutionCountingAspect countingAspect =
				context.getBean(ExecutionCountingAspect.class);
		System.out.println("Total execuiton count: " + 
				countingAspect.getExecutionCount());
		
	}
	
	public static void checkIntroductionAspect(
			ApplicationContext context) {
		
		AccountService accountService = 
				context.getBean(AccountService.class);
		
		Account validAccount = new Account();
		validAccount.setId("12345");
		validAccount.setOwnerName("Sungwon Seo");
		validAccount.setBalance(1000.0);
		
		accountService.updateAccount(validAccount);
		List<Account> accounts1 = accountService.findAccounts("hello world");
				
		
		Account invalidAccount = new Account();
		invalidAccount.setId("6789");
		invalidAccount.setOwnerName("sumin Seo");
		invalidAccount.setBalance(-5000.0);
		
		accountService.updateAccount(invalidAccount);
		
		UsageTracked usageTracked = (UsageTracked) accountService;
		
		System.out.println("AccountService usage count: " + usageTracked.getUseCount());
	}

	public static void checkAspectInstantiationModels(
			ApplicationContext context) {
		SampleService sampleService1 = 
				(SampleService) context.getBean("sampleService");
		
		MyType myTypeInstance1 = new MyType("ExampleName");
		
		sampleService1.sampleMethod("hello");
		
		sampleService1.sampleGenericMethod(myTypeInstance1);
		
		sampleService1.sampleGenericCollectionMethod(Arrays.asList(myTypeInstance1));
		
		SampleService sampleService2 = 
				(SampleService) context.getBean("sampleService");
		
		MyType myTypeInstance2 = new MyType("ExampleName2");
		
		sampleService2.sampleMethod("world");
		
		sampleService2.sampleGenericMethod(myTypeInstance2);
		
		sampleService2.sampleGenericCollectionMethod(Arrays.asList(myTypeInstance2));
	}

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		checkAspectInstantiationModels(context);
		
//		checkIntroductionAspect(context);
		
//		checkAutomicThreadSafe(context);
		
//		adviceParametersAndGenerics(context);
//		checkAroundAdviceThroughAccountAccountService(context);
		
//		checkAfterThrowingAdviceThroughAccountAccountService(context);
		
		
	}

}
