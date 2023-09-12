package com.ssafy.di2;

public class Test {
	public static void main(String[] args) {
		// 제어의 역전
		// 의존관계 역전
		// 강한 결합
		Desktop computer = new Desktop();
//		Laptop computer = new Laptop();

		Programmer p = new Programmer(computer);
		p.coding();
	}
}
