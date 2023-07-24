package test03_super;

public class Student extends Person {
	String major;

	public Student() {
		// super(); 가 생략되어 있다. (부모의 기본 생성자를 호출한다.).
		System.out.println("Student의 기본 생성자입니다.");
		// super(); 가 아래에 작성되어 있다면 컴파일 에러가 난다. super(); 구문은 생성자에 맨 위에 위치해있어야 한다.
		// 비슷하게도 this()도 상단에 위치해야 한다. 단, this보다는 super가 먼저이고 둘은 같이 사용할 수 없다.
	}
	
	public Student(String major) {
		this.major = major;
	}

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public void study() {
		super.eat(); // 음식을 먹는다. (부모 클래스의 메소드 호출)
		super.age = 10;
		System.out.println("공부를 한다.");
	}
	
}
