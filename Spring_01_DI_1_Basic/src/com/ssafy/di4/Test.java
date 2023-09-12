package com.ssafy.di4;

// 설정자(setter)를 통한 의존성 주입
public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();

		Programmer p = new Programmer();
		p.setComputer(desktop);
		p.coding();
		
		p.setComputer(laptop);
		p.coding();
		
	}
}
