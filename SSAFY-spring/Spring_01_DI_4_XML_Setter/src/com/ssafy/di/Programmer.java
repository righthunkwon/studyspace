package com.ssafy.di;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Computer computer;
	
	// 기본 생성자
	public Programmer() {
	}
	
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
			
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
