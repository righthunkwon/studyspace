package modifier03_protected2;

import modifier03_protected.Person;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.info();
		// p.name = "KWON"; // 불가
		// p.age = 28; // 불가
	}
}
