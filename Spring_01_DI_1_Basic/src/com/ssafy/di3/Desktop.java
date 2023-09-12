package com.ssafy.di3;

// 인터페이스를 구현할 경우
// 1. 인터페이스에 있는 메소드를 구현하든지,
// 2. 클래스를 추상 클래스로 만들든지 해야 한다.
public class Desktop implements Computer {
	// 필드(생략)
	// CPU, 그래픽카드, 메모리, ...
	
	// 메소드
	public String getInfo() {
		return "Desktop";
	}
}
