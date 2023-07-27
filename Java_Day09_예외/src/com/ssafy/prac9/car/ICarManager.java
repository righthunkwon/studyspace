package com.ssafy.prac9.car;

public interface ICarManager {

	void add(Car car);

	Car[] getList();

	Car[] searchByModelName(String modelName) throws ModelNameNotFoundException;

	ElectricCar[] getElectricCars();

	int getTotalMileage();
}

