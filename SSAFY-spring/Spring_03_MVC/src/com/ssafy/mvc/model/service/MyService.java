package com.ssafy.mvc.model.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	// 이후 Database와 연동하는 법을 배운 뒤에는
	// Service와 DAO를 연결 해야한다(DAO는 DB와 통신).
	public void doSometing() {
		System.out.println("작업 처리");
	}
}
