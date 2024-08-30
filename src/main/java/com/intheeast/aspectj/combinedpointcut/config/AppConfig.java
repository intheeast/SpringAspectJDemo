package com.intheeast.aspectj.combinedpointcut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intheeast.aspectj.combinedpointcut.pointcuts.CommonPointcuts;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.intheeast.aspectj.combinedpointcut")
public class AppConfig {
	
	

}
