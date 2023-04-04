package java04_oop;

		/*
			Car이라는 상위 클래스에 Bus나 Truck과 같은 하위 클래스를 만들기
				
				상속 : 상위클래스 - 하위클래스
				Car이라는 상위 클래스에 공통적인 기능을 구현한 뒤,
				이를 Bus와 Truck에 호출한다.
		*/
public class Car {
	String model;
	String color;
	int speed;
	final int maxSpeed = 200;
	
	public Car() {
		System.out.println("Car()생성자");
	}
	public Car(String model, String color) {
		this(); // Car()생성자
		this.model = model;
		this.color = color;
		System.out.println("Car(String model, String color)생성자 : "+this.model+", "+this.color);
	}
	
	// break
	public void speedDown() {
		speed--;
		if(speed<0) {
			speed = 0;
		}
	}
	
	// accel
	public void speedUp() {
		speed++;
		if(speed>maxSpeed) {
			speed = maxSpeed;
		}
	}


}
