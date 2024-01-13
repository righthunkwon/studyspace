package com.ssafy.prac10.car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CarManagerImpl implements ICarManager {
	// 관리하는 자동차 리스트
	private List<Car> carList = new ArrayList<Car>();

	// 싱글톤 디자인패턴을 위해 유지하는 객체 참조
	// 클래스가 메모리에 로드될 때 객체를 1번만 생성하여 참조를 유지한다.
	private static ICarManager instance = new CarManagerImpl();

	// 외부에서 객체 생성을 하지 못하도록 생성자를 private 으로 선언
	private CarManagerImpl() {
		// 객체가 생성될 때 파일을 읽어와 저장
		loadData();
	}

	// 내부에서 생성한 객체의 참조를 반환한다.
	public static ICarManager getInstance() {
		return instance;
	}

	// ArrayList는 크기의 제한이 없으므로 저장 성공/실패를 boolean으로 반환하지 않아도 된다.
	@Override
	public void add(Car car) {
		carList.add(car);
	}

	@Override
	public Car[] getList() {
		Car[] result = new Car[carList.size()];

		for (int i = 0; i < carList.size(); i++) {
			result[i] = carList.get(i);
		}

		return result;
	}

	// 해당 모델명으로 자동차를 찾지 못했을 경우 에러를 발생시킨다.
	@Override
	public Car[] searchByModelName(String modelName) throws ModelNameNotFoundException {
		List<Car> tempList = new ArrayList<Car>();

		for (Car c : carList) {
			if (c.getModelName().contains(modelName))
				tempList.add(c);
		}

		if (tempList.size() == 0)
			throw new ModelNameNotFoundException(modelName);

		Car[] result = new Car[tempList.size()];
		for (int i = 0; i < tempList.size(); i++) {
			result[i] = tempList.get(i);
		}
		return result;
	}

	@Override
	public ElectricCar[] getElectricCars() {
		List<ElectricCar> tempList = new ArrayList<ElectricCar>();

		for (Car c : carList) {
			if (c instanceof ElectricCar)
				tempList.add((ElectricCar) c);
		}
		ElectricCar[] eList = new ElectricCar[tempList.size()];

		for (int i = 0; i < tempList.size(); i++) {
			eList[i] = tempList.get(i);
		}

		return eList;
	}

	@Override
	public int getTotalMileage() {
		int total = 0;

		for (Car c : carList) {
			total += c.getMileage();
		}

		return total;
	}

	private void loadData() {
		File file = new File("car.dat");
		if (file != null) { // 파일이 존재하면 파일에서 데이터 읽기
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				carList = (List<Car>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.dat"))) {
			oos.writeObject(carList);
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}

}
