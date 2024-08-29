package com.intheeast.aspectj.declaringpointcut.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// StereoType: 정형화하다...
// Spring에서 @Component를 "스테레오타입(stereotype)" 애너테이션이라고 정의하는 이유는, 
// 이 애너테이션이 클래스의 역할과 목적을 나타내는 메타데이터를 제공하기 때문입니다. 
// 스테레오타입 애너테이션은 개발자가 특정 클래스가 애플리케이션 내에서 어떤 역할을 수행하는지 명확하게 표현하도록 돕습니다.
@Service
public class TransferService {

	public void transfer(String account, double amount) {
		System.out.println("*******************************************************************");
		System.out.println("Transfering " + amount + 
				" to account " + account);
		System.out.println("*******************************************************************");
	}
	
	public void checkBalance() {
		System.out.println("*******************************************************************");
		System.out.println("check balance");
		System.out.println("*******************************************************************");
	}
}
