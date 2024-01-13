package com.ssafy.board.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Swagger를 활용한 REST API 문서화
// 프로젝트 개발 시 FE 개발자와 BE 개발자는 분리되어
// FE 개발자의 경우에는 화면에 집중하고 BE 개발자는 서버에 집중하여 개발을 하게 된다.

// 이때 개발 상황의 변화에 따라 API가 추가되거나 변경될 때마다 
// API 문서에 이를 반영해야 하는 불편함이 생기는데, 이를 해결하기 위해 Swagger를 활용할 수 있다.

// Swagger를 사용하면
// 간단한 설정으로 프로젝트의 API 목록을 웹에서 확인 및 테스트할 수 있으며,
// Controller에 정의되어 있는 모든 URL을 바로 확인할 수 있고, API를 직접 테스트하거나 설명을 볼 수도 있다.

// Swagger 설정 파일
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.board.controller"))
				.paths(PathSelectors.ant("/*/api/**"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SSAFY 10기 BOARD REST API")
				.description("엄청나게 대단한 게시판을 위한 레스트풀한 서버 입니다.")
				.version("0.1")
				.build();
	}
}
