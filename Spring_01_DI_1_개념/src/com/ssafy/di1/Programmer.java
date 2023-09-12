package com.ssafy.di1;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Desktop computer;
	
	// (1) Desktop
	public Programmer() {
		computer = new Desktop();
	}
	
	// (2) Laptop
//	public Programmer() {
//		computer = new Laptop();
//	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
