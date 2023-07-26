package com.ssafy.prac8.car;

public interface ICarManager {

	void add(Car car);

	Car[] getList();

	Car[] searchByModelName(String modelName);

	ElectricCar[] getElectricCars();

	int getTotalMileage();
}

