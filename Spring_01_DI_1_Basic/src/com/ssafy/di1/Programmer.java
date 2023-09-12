package com.ssafy.di1;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Desktop computer;
	
	// 생성자
	public Programmer() {
		// 프로그래머 클래스는 데스크탑에 대한 객체 생성 의존성을 가지고 있다.
		computer = new Desktop();
	}

	// 메소드
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
