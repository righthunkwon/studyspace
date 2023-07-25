package modifier04_public;

// class는 public 아니면 default
public class Person {
	public String name;
	public int age;
	
	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}