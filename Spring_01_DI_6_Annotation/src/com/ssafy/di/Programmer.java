package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Computer computer;
	
	// 기본 생성자
	public Programmer() {
	}
			
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
