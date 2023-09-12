package com.ssafy.di;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Computer computer;
	
	// 기본 생성자
	public Programmer() {
	}
	
	// applicationContext.xml에서  
	// bean 내부에 constructor를 생성하였으므로
	// 파라미터를 받을 수 있는 생성자를 통해 bean이 생성된다.
	public Programmer(Computer computer) {
		this.computer = computer;
	}
			
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
