package java04_oop;

// Car 클래스를 상속받는다. (extends Car)
// 상속은 한 개만 받을 수 있다.
// 상속관계에서 생성자 메소드는 상위클래스의 생성자를 먼저 실행하고 이후 하위클래스의 생성자를 실행한다.
public class Bus extends Car {
	int maxSpeed = 150; // maxSpeed 의 변화
	public Bus() {
		// 하위 클래스의 생성자 메소드에서 상위 클래스의 원하는 생성자 메소드를 호출하기 (단, 첫째줄에 명시해야 한다)
		// this() : 현재클래스의 생성자
		// super() : 상위클래스의 생성자
		super("마을버스", "green");
		System.out.println("Bus()생성자");
		System.out.println("change maxSpeed : " + maxSpeed);
	}
	public void output() {
		System.out.println("모델 : "+ model);
		System.out.println("색상 : "+ color);
		System.out.println("최고속도 : "+ maxSpeed);
		// 상위클래스의 멤머변수에 속한 maxSpeed 호출 : super 키워드 활용
		System.out.println("Car의 최고속도 : "+ super.maxSpeed);
	}
	
	// 오버라이딩(override) : 하위클래스에서 상위클래스의 메소드를 재정의하는 것
	// 메소드명, 매개변수의 갯수, 데이터형이 같아야 한다.
	// 접근제어자는 상위클래스의 접근제어자보다 넓거나 같은 제어자여야 한다.
	public void speedUp() { // 하위클래스의 별도의 speedUp
		super.speedUp(); // 상위클래스의 speedUp 호출
		speed += 10;
		if(speed >= maxSpeed) {
			speed = maxSpeed;
		}
	}

	public static void main(String[] args) {
		Bus bus = new Bus(); // 객체를 Bus로 생성했음에도 상위 클래스인 Car이 먼저 실행된다.
		bus.output();
		bus.speedUp();
		System.out.println("bus의 현재속도 : "+ bus.speed);
	}

}
