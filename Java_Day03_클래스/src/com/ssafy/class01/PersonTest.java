package com.ssafy.class01;

public class PersonTest {
	public static void main(String[] args) {
		// 1. 변수로 정리(불편)
		String name1 = "Yang";
		String name2 = "Hong";
		
		int age1 = 45;
		int age2 = 25;
		
		String hobby1 = "Youtube";
		String hobby2 = "Golf";
		
		// 2. 배열로 정리(불편)
		int size = 2;
		String[] names = new String[size];
		names[0] = "Yang";
		names[1] = "Hong";
		
		int[] ages = new int[size];
		ages[0] = 45;
		ages[1] = 25;
		
		String[] hobbies = new String[size];
		hobbies[0] = "Youtube";
		hobbies[1] = "Golf";
		
		// 3. 클래스로 정리(편안)
		// 클래스는 설계도
		// 클래스는 붕어빵 틀
		// 클래스로 인스턴스인 붕어빵을 만든다.
		// package class02에서 살펴본다.
	}
}
