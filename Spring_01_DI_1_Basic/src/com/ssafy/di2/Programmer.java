package com.ssafy.di2;

public class Programmer {
	// 필드(생략)
	// 이름, 나이, 언어, ... 컴퓨터
	private Desktop computer;
	
	// 기존 di1 코드에서는 프로그래머 클래스에서 desktop 클래스를 생성하여 사용하였지만,  
	// di2 코드에서는 프로그래머 클래스의 생성자에 desktop 인스턴스를 넣고,
	// 이후 Test 클래스(메인 메소드)에서 객체를 생성하여 인자로 넣는다.
	
	// 의존성 주입을 통한(파라미터 변수로 삽입) 객체 생성 의존성(new) 제거
	public Programmer(Desktop computer) {
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
