package com.ssafy.di5;

// 팩토리 패턴
public class ComputerFactory {
	public static Computer getComputer(String type) {
		if (type.equals("D")) {
			return new Desktop();
		} else if (type.equals("L")) {
			return new Laptop();
		} else {
			return null;
		}
	}
}
