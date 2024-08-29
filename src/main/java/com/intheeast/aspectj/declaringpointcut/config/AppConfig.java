package com.intheeast.aspectj.declaringpointcut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intheeast.aspectj.declaringpointcut.service.SpecialService;
import com.intheeast.aspectj.declaringpointcut.service.TransferService;

@Configuration
@ComponentScan(basePackages="com.intheeast.aspectj.declaringpointcut")
@EnableAspectJAutoProxy
public class AppConfig {
	
	

//	@Bean
//	public SpecialService specialSevice() {
//		return new SpecialService();
//	}
//	
//	@Bean
//	public TransferService transferSevice() {
//		return new TransferService();
//	}
}
