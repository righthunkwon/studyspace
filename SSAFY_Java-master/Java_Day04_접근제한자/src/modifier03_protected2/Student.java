package modifier03_protected2;

import modifier03_protected.Person;

public class Student extends Person {
	
	public static void main(String[] args) {
		Student s = new Student();
		// protected는 상속받을 경우 사용할 수 있다.
		s.info();
		s.name = "KWON";
		s.age = 28;
	}
	
}