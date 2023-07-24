package test04_overriding;

public class Student extends Person {
	String major;
	
	// 메소드 오버라이딩(부모 클래스의 메소드를 자식 클래스에서 재정의)
	// 부모클래스에 eat()이라는 메소드가 있었어도 자식클래스에 eat()을 재정의하면 자식클래스의 메소드가 우선하여 실행한다.
	public void eat() {
		System.out.println("지식을 먹는다.");
		super.eat(); // 부모의 eat() 호출
	}
	
}
