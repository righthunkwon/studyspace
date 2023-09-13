package com.ssafy.ws;

public class Driver {
	// 빈 등록(applicationContext.xml)
	// (1) bean 태그
	// (2) component-scan
	
	// 의존성 주입
	// (1) 필드
	// (2) 생성자
	// (3) 설정자

	private Car car;

	public Driver() {
	}
	
	public Driver(Car car) {
		this.car = car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void drive() {
		System.out.println(car.getInfo() + "를 운전합니다.");
	}
}
