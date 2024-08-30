package com.intheeast.aspectj.declaringadvice;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectj.declaringadvice.config.AppConfig;
import com.intheeast.aspectj.declaringadvice.dao.AccountDao;
import com.intheeast.aspectj.declaringadvice.model.Account;
import com.intheeast.aspectj.declaringadvice.service.AccountService;
import com.intheeast.aspectj.declaringadvice.service.AccountServiceImpl;
import com.intheeast.aspectj.declaringadvice.service.MyService;

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
		myService.performTask();
	}

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		checkAroundAdviceThroughAccountAccountService(context);
		
//		checkAfterThrowingAdviceThroughAccountAccountService(context);
		
		
	}

}
