package com.ssafy.prac6;

public class CarManager {
	// 관리하는 자동차 정보 배열 크기 100
	private Car[] carList = new Car[100];
	// 현재 등록된 자동차 정보 수
	private int size = 0;

	// 자동차 등록
	// 전체의 개수가 100개가 넘지 않을 때 저장하고 true를 반환 넘었다면 false를 반환
	public boolean add(Car car) {
		if (size < 100) {
			carList[size++] = car;
			return true;
		}
		return false;
	}

	// 현재 등록된 자동차 반환
	public Car[] getList() {

		Car[] result = new Car[size];

		for (int i = 0; i < size; i++) {
			result[i] = carList[i];
		}

		return result;
	}

	// 해당 인자를 가진 자동차 배열 반환
	public Car[] searchByModelName(String modelName) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName))
				cnt++;
		}

		Car[] result = new Car[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName))
				result[idx++] = carList[i];
		}
		return result;
	}

	// 전체 등록된 자동차 중에서 전기차만 반환
	public ElectricCar[] getElectricCars() {
			int cnt = 0;
			for (int i = 0; i < this.size; i++) {
				if (carList[i] instanceof ElectricCar)
					cnt++;
			}

			ElectricCar[] eList = new ElectricCar[cnt];

			int idx = 0;
			for (int i = 0; i < this.size; i++) {
				if (carList[i] instanceof ElectricCar)
					eList[idx++] = (ElectricCar) carList[i];
			}

			return eList;
		}

	// 등록된 모든 차량의 주행거리의 합 반환
	public int getTotalMileage() {
		int total = 0;

		for (int i = 0; i < this.size; i++) {
			total += carList[i].getMileage();
		}

		return total;
	}
}
