package com.ssafy.di3;

public class Test {
	public static void main(String[] args) {
		// 느슨한 결합
		Desktop computerD = new Desktop();
		Laptop computerL = new Laptop();
		
		Programmer p = new Programmer(computerD);
		p.coding();
	}
}
