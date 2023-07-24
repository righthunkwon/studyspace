package modifier02_default2;

import modifier02_default.Person;

public class PersonTest {
	public static void main(String[] args) {
		// Person과 PersonTest는 다른 클래스이면서 다른 패키지이다.
		// 따라서 다른 패키지에는 접근할 수 없는 default 변수는 접근할 수 없다/ 
		Person p = new Person();
		p.info(); // public
		// p.name = "KWON"; // default에 다른 패키지는 접근 불가 
		// p.age = 28; // default에 다른 패키지는 접근 불가
	}
}
