package test05_object;

public class Student extends Person {
	String major;
	
	// 메소드 오버라이딩(부모 클래스의 메소드를 자식 클래스에서 재정의)
	// 부모클래스에 eat()이라는 메소드가 있었어도 자식클래스에 eat()을 재정의하면 자식클래스의 메소드가 우선하여 실행한다.
	public void eat() {
		System.out.println("지식을 먹는다.");
	}

	@Override
	public String toString() {
		return "Student [majortest=" + major + ", name=" + name + ", age=" + age + "]";
	}
	
	// 재정의한 equals() 메소드
	public boolean equals(Student st) {
		return name.equals(st.name);
	}
}
