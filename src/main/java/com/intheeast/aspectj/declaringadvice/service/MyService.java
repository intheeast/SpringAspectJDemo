package com.intheeast.aspectj.declaringadvice.service;

@FunctionalInterface
interface printMethodName {
	void printX(String functionName);	
}


public class MyService {
	// 아래 람다 표현식이 다수의 메서드 아규먼트로 사용된다면,,,
	// functionname -> System.out.println("function name: " + functioname); 
	public void performTask() {
		System.out.println("MyService::performTask:Performing a task ...");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
