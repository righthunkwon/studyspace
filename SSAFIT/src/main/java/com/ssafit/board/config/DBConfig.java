package com.ssafit.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 파일 명시
@MapperScan(basePackages = "com.ssafit.board.model.dao")
public class DBConfig {

}