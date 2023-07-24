package com.ssafy.class03;

public class Car {
	// 클래스 변수
	static String manufacturer = "Example Motors";

	// 인스턴스 변수
	String model;

	public Car(String model) {
		// 인스턴스 변수 초기화
		this.model = model;
	}

	public void drive() {
		// 지역 변수
		int fuelLevel = 100;
		System.out.println("Driving " + manufacturer + " " + model);
		System.out.println("Fuel level: " + fuelLevel);
	}

	public static void main(String[] args) {
		// 클래스 변수에 접근
		System.out.println(Car.manufacturer); // 출력: Example Motors

		// 인스턴스 생성
		Car car1 = new Car("Sedan");
		Car car2 = new Car("SUV");

		// 인스턴스 변수에 접근
		System.out.println(car1.model); // 출력: Sedan
		System.out.println(car2.model); // 출력: SUV

		
		// 인스턴스 메서드 호출
		System.out.println("-----------");
		car1.drive();
		System.out.println("-----------");
		car2.drive();
	}
}
