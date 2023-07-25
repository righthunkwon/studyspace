package modifier01_private;

public class PersonTest {
	public static void main(String[] args) {
		// Person과 PersonTest는 다른 클래스이다.
		Person p = new Person();
		p.info(); // public인 info() 메소드는 다른 패키지에서 접근 가능하다/
		// p.name; // 하지만 private인 name과 age 변수는 다른 패키지에서 접근할 수 없다.
		// p.age; // 
		

	}
}
