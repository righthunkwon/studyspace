package com.ssafy.class03;

public class Person {
	// 클래스 변수
	static int personCount;
	
	// 인스턴스 변수
	String name;
	int age;
	String hobby;
	
	public void showPersonInfo() {
		// 지역변수
		char grade;
		
		System.out.println("나의 이름은 " + name + "입니다.");
		System.out.println("나이는 " + age + "세, 취미는 " + hobby + "입니다.");
	}
	
	public void study(int time) {
		// int time은 인자가 아니라 매개변수(메서드를 정의할 )
		System.out.println(time + "시간 만큼 공부했습니다.");
	}
	
	// 메소드 오버로딩
	// 이름이 같고 매개변수가 다른 메소드를 여러 개 정의하는 것
	// 파라미터의 개수 또는 순서 또는 타입이 달라야 한다.
	// 리턴 타입이 다른 건 의미가 없다.
	public void study(long time) {
		// int time은 인자가 아니라 매개변수(메서드를 정의할 )
		System.out.println(time + "시간 만큼 공부했습니다.");
	}
}
