package polymorphism01;

public class Student extends Person {
	String major;

	public Student() {
	}

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public void study() {
		System.out.println("공부를 한다.");
	}

}
