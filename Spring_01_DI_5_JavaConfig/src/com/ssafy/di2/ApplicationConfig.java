package com.ssafy.di2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 빈 등록 방법 (2) 
// @Configuration & @ComponentScan(basePackages = {""})

@Configuration
@ComponentScan(basePackages = {"com.ssafy.di2"})
public class ApplicationConfig {
	
}
 