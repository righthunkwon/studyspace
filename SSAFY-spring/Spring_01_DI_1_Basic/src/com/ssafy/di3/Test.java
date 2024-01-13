package com.ssafy.di3;

// 생성자를 통한 의존성 주입
public class Test {
	public static void main(String[] args) {
		// 느슨한 결합
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();

		Programmer p = new Programmer(desktop);
//		Programmer p = new Programmer(laptop);
		p.coding();
		
	}
}
