package com.ssafy.di2;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Desktop computerD;
	private Laptop computerL;
	
	// 의존성 주입
	// 생성자를 통해서 넣는다.
	public Programmer(Desktop computerD) {
		this.computerD = computerD;
	}
	
	public Programmer(Laptop computerL) {
		this.computerL = computerL;
	}
	
	public void coding() {
		System.out.println(computerD.getInfo() + "(으)로 개발한다.");
	}
	
}
