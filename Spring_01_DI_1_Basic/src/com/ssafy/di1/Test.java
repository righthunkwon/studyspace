package com.ssafy.di1;

// 의존이란 무엇인가?
public class Test {
	// 클래스 A 객체가 어떤 일을 처리하기 위해 
	// 클래스 B의 객체의 도움을 받아야만 일을 처리할 수 있다면
	// 클래스 A는 클래스 B에 의존한다고 표현한다.
	
	// Programmer는 Desktop를 사용하려면
	// 매번 Desktop의 인스턴스를 만들어서 사용해야 한다.
	
	// 즉, Programmer는 Desktop 클래스에 의존하고 있다(강한 결합).
	public static void main(String[] args) {
		Programmer p = new Programmer();
		p.coding();
	}
}
