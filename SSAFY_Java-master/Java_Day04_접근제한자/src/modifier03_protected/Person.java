package modifier03_protected;

// class는 public 아니면 default
public class Person {
	protected String name;
	protected int age;

	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}