package modifier06_singleton;

public class PersonTest {
	public static void main(String[] args) {
		// 객체가 단 하나만 필요할 때 싱글턴 패턴을 적용할 수 있다.
		// 싱글턴 패턴에서 p1과 p2는 동일하다.
		Person p1 = Person.getInstance();
		Person p2 = Person.getInstance();
	}
}
