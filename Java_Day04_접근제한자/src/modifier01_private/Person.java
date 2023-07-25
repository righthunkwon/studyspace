package modifier01_private;

// class는 public 아니면 default
public class Person {
	// private : 같은 클래스 내에서만 사용 가능
	private String name;
	private int age;

	// Person 클래스에 속한 info() 메소드는
	// 같은 클래스에 속한 private으로 선언된 변수 사용 가능
	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}