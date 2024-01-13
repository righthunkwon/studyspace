package com.ssafy.no.proxy;

// 관점 지향 프로그래밍(AOP)
// https://code-lab1.tistory.com/193
// OOP(Object Oriented Programming)에서 모듈화의 핵심 단위는 클래스이지만,
// AOP(Aspect Oriented Programming)에서 모듈화의 핵심 단위는 관점(Aspect)이다.
// 관심사항에 따라 관점은 핵심적인 관점(비지니스 핵심 로직), 공통적인 관점(로그인,회원가입 등)으로 나눈다.
// 이때, 관점은 필드,메소드,클래스마다 흩어져 있는데 이를 흩어진 관심사(Crosscutting concerns)라 한다.
// 관점 지향 프로그래밍의 핵심은 이러한 흩어진 관심사를 모듈화하여 Aspect로서 모으는 것이다.
public class Test {
	public static void main(String[] args) {
		// AOP(관점 지향 프로그래밍)
		// 프로그래머와 싸피인의 차이는 
		// 핵심관심사항인 코드 작성 vs 공부 하기에서만
		// 차이를 보이기 때문에 핵심관심사항만 따로 빼서 관리하고
		// 나머지 요소들은 모아서 따로 관리하고 싶다는 생각이 든다.
		
		Programmer p = new Programmer();
		p.coding();
		
		System.out.println("==================");
		
		Ssafy s = new Ssafy();
		s.coding();
	}
}
