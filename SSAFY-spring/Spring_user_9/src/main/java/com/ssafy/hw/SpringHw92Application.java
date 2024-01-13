package com.ssafy.hw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.hw.interceptor.SessionInterceptor;

@SpringBootApplication
// mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.hw.model.dao"/>를 대체한다.
@MapperScan(basePackages = "com.ssafy.hw.model.dao")
// 인터셉터 설정 추가를 위해 WebMvcConfigurer 인터페이스를 implements 한다.
public class SpringHw92Application implements WebMvcConfigurer {

	@Autowired
	SessionInterceptor sessionInterceptor;

	// 인터셉터 설정 추가
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor).addPathPatterns("/regist");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringHw92Application.class, args);
	}

}
