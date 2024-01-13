package modifier06_singleton;

// 싱글턴 패턴을 적용한 Person 클래스
public class Person {
	// 1. 기본 생성자를 private하게 작성한다.
	// 2. 그리고 인스턴스를 private하게 작성한다.
	private Person() {
	}
	private static Person instance = new Person();
	
	// 3. 외부에서 instance를 가져다 쓸 수 있게끔 getter과 setter를 public으로 작성한다.
	// 4. 외부에서 미리 가져다 쓰고 싶은데 메모리에 미리 올려놓기 위해 인스턴스와 메소드에 static을 작성한다.
	public static Person getInstance() {
		// 하단과 같이 인스턴스를 만들 수도 있다.
//		if (instance == null) {
//			instance = new Person();
//		}
		return instance;
	}
	public static void setInstance(Person instance) {
		Person.instance = instance;
	}
	
}
