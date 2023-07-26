package com.ssafy.prac8.car;

public class ElectricCar extends Car {
	// 전기자동차 배터리 량
	private int battery;

	public ElectricCar() {
	}

	public ElectricCar(String VIN, String modelName, String color, int mileage, int battery) {
		super(VIN, modelName, color, mileage);
		this.battery = battery;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return super.toString() + "+ battery=" + battery + "]";
	}

}

