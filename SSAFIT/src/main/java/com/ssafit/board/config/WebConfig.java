package com.ssafit.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
	}
	
	// 등록할 인터셉터가 있다면 
	// 필드를 통해 의존성을 주입 받고
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 등록하면 된다.
	}

	// CORS 에러를 해결하기 위해 컨트롤러마다 @CrossOrigin를 추가해도 되지만
	// WebConfig(WebMvcConfigurer)에서 이를 한 번에 처리할 수도 있다.
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}
	
}