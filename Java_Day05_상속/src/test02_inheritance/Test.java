package test02_inheritance;

public class Test {
	public static void main(String[] args) {
		Person ps = new Person();
		Student st = new Student();


		// 학생은 사람이다. O
		// 학생은 학생이다. O
		// 사람은 학생이다. O / X

		// 최상위 객체
		if (ps instanceof Object) {
			System.out.println("ps는 Object를 참조한다.");
		}
		// Person 객체
		if (ps instanceof Person) {
			System.out.println("ps는 Person을 참조한다.");
		}
		// Student 객체
		if (ps instanceof Student) {
			System.out.println("ps는 Student를 참조한다.");
		}
		// Programmer 객체
		if (ps instanceof Programmer) {
			System.out.println("ps는 Programmer를 참조한다.");
		}
		
		System.out.println("--------------");
		
		// 최상위 객체
		if (st instanceof Object) {
			System.out.println("st는 Object를 참조한다.");
		}
		// Person 객체
		if (st instanceof Person) {
			System.out.println("st는 Person을 참조한다.");
		}
		// Student 객체
		if (st instanceof Student) {
			System.out.println("st는 Student를 참조한다.");
		}
		// Programmer 객체
		// Student와 Programmer는 관련이 없으므로 컴파일 에러 발생
//		if (st instanceof Programmer) { 
//			System.out.println("ps는 Programmer를 참조한다.");
//		}
	}
}