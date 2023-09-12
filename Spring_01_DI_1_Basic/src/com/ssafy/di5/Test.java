package com.ssafy.di5;

import java.util.Scanner;

// 설정자(setter)를 통한 의존성 주입
// 팩토리 패턴 활용
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Programmer p = new Programmer();
		
		while(true) {
			p.setComputer(ComputerFactory.getComputer(sc.next()));
			p.coding();
		}
	}
}
