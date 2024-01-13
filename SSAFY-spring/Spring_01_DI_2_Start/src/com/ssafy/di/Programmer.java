package com.ssafy.di;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	
	// 기본 생성자 이외의 다른 생성자가 있을 경우 이때
	// 기본 생성자가 없다면 applicationContext.xml에서 
	// 빈 객체를 만들 때 기본 생성자가 자동으로 생성되지 않으므로 에러가 발생할 수 있다.
	
	// 따라서 스프링의 빈을 통해 자바의 클래스를 관리할 경우에는  
	// 클래스마다 기본 생성자를 의도적으로 만들어두는 것이 에러를 줄일 수 있다.
	
	// 기본 생성자
	public Programmer() {
	}
			
	public void coding(Computer computer) {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
