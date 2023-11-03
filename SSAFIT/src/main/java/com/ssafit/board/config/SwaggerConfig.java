package com.ssafit.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// Swagger를 활용한 REST API 문서화
// 프로젝트 개발 시 FE 개발자와 BE 개발자는 분리되어
// FE 개발자의 경우에는 화면에 집중하고 BE 개발자는 서버에 집중하여 개발을 하게 된다.

// 이때 개발 상황의 변화에 따라 API가 추가되거나 변경될 때마다 
// API 문서에 이를 반영해야 하는 불편함이 생기는데, 이를 해결하기 위해 Swagger를 활용할 수 있다.

// Swagger를 사용하면
// 간단한 설정으로 프로젝트의 API 목록을 웹에서 확인 및 테스트할 수 있으며,
// Controller에 정의되어 있는 모든 URL을 바로 확인할 수 있고, API를 직접 테스트하거나 설명을 볼 수도 있다.

// Swagger 설정 파일
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafit.board.controller"))
				// paths에서 
				// *는 경로의 바로 하위에 있는 모든 경로를 매핑한다(있어도 되고 없어도 된다).
				// **는 경로의 모든 하위 경로를 매핑한다(있어도 되고 없어도 된다).
				// AAA/*는 AAA/BBB와 AAA/CCC는 되지만 AAA/BBB/CCC는 안 되고,
				// AAA/**는 AAA/BBB, AAA/CCC, AAA/BBB/CCC 모두 가능하다.
				.paths(PathSelectors.ant("/api*/**"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SSAFIT REST API")
				.description("레스트풀한 싸핏 구현!")
				.version("1.0")
				.build();
	}
}
