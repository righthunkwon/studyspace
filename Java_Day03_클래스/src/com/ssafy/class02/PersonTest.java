package com.ssafy.class02;

public class PersonTest {

	public static void showPersonInfo(String name, int age, String hobby) {
		System.out.println("나의 이름은 " + name + "입니다.");
		System.out.println("나이는 " + age + "세, 취미는 " + hobby + "입니다.");
	}
	
	public static void main(String[] args) {
		showPersonInfo("권정훈", 28, "게임");
	}
}
