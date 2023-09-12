package com.ssafy.di3;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Computer computer;
	
	// 의존성 주입
	// 생성자를 통해서 넣는다.
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	// 설정자(setter) 주입
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
