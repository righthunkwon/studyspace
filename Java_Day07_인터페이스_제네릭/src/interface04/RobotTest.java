package interface04;

interface Movable {
	public abstract void move();
}

interface Cookable {
	public abstract void cook();
}

interface Chef extends Movable, Cookable {
	// static method
	public static void sound() {
		System.out.println("보글보글");
	}
	
	// default method
	public default void info() {
		System.out.println("정보 출력");
	}
}

class Robot implements Chef {

	@Override
	public void move() {
		
	}

	@Override
	public void cook() {
		
	}
	
}

public class RobotTest {
	public static void main(String[] args) {
		// static method
		// interface는 객체 생성 불가
		Chef.sound();
		
		// default method
		// interface를 상속받은 구현 클래스는 객체 생성 가능
		Robot r = new Robot();
		r.info();
	}
}
