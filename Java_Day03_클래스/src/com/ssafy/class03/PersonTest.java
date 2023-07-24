package com.ssafy.class03;

public class PersonTest {
	public static void main(String[] args) {
		Person personKwon = new Person();
		personKwon.name = "권정훈";
		personKwon.age = 28;
		personKwon.hobby = "Coding";
		personKwon.showPersonInfo();
		personKwon.study(8); // 묵시적 형변환 사용, 10은 매개변수가 아니라 인자, 메서드를 호출할 때는 인자
		// personKwon.study((float)10.0F); // 컴파일 에러 발생, 형변환 불가
		
		Person personKim = new Person();
		personKim.name = "김싸피";
		personKim.age = 100;
		personKim.hobby = "Coding";
		personKim.showPersonInfo();
		personKim.study(100L);
	}
}
