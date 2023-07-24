package com.ssafy.prac5;

public class CarManager {
	// 관리하는 자동차 정보 배열 크기 100
	private Car[] carList = new Car[100];
	// 현재 등록된 자동차 정보 수
	private int size = 0;

	// (1) 자동차 등록
	// 전체의 개수가 100개가 넘지 않을 때 저장하고 true를 반환, 넘었다면 false를 반환
	public boolean add(Car car) {
		// 빈칸의 개수가 1개라고 생각하지 말것
		if (size < 100) {
			carList[size] = car;
			size++;
			return true;
		} else {
			return false;
		}
	}

	// (2) 현재 등록된 자동차 반환
	public Car[] getList() {
		Car[] result = new Car[size];
		for (int i = 0; i < this.size; i++) {
			result[i] = carList[i];
		}
		return result;
	}

	// (3) 해당 인자를 가진 자동차 배열 반환
	public Car[] searchByModelName(String modelName) {
		int cnt = 0;
		// int size = 0;
		for (int i = 0; i < this.size; i++) { // 기본적으로는 this를 붙여줘도 안 붙여줘도 상관 없다.
			// 하지만, 위에 지역변수로서 int size = 0가 선언되어 있을 경우에
			// 해당 size와 구별해주기 위해 이 size는 인스턴스 멤버임을 알려주기 위하여
			// this를 사용할 수 있다. 지금은 지역변수로 size가 없으니 this.size를 하지 않고
			// size라 선언하여도 size가 인스턴스 멤버 하나이기에 잘 받아올 수 있다.
			if (carList[i].getModelName().contains(modelName)) {
				cnt++;
			}
		}

		Car[] result = new Car[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName))
				result[idx++] = carList[i];
		}
		return result;
	}
}
