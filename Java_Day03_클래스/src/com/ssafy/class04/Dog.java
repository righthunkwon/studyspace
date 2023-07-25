package com.ssafy.class04;

public class Dog {
	String name;
	
	// 기본 생성자
	// 매개변수가 없는 생성자, 클래스명과 동일하게 작성, 반환타입도 없다
	// 생성자를 작성하지 않아도 JVM은 기본 생성자를 자동으로 생성한다.
	public Dog() {
		System.out.println("기본 생성자");
	}
	
	// 파라미터가 있는 생성자
	// 생성자의 목적은 필드 초기화
	// 해당 생성자를 작성하면 JVM에서 기본 생성자를 추가하지 않는다.
	public Dog(String name) {
		// 지역변수와 매개변수를 구분하기 위한 this
		this.name = name;
		System.out.println("파라미터가 있는 생성자");
		System.out.println("이름 : " + name);
	}
}
