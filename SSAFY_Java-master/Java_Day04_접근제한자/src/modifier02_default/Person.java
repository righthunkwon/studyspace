package modifier02_default;

// class는 public 아니면 default
public class Person {
	String name; // 접근제한자를 생략하면, 접근제한자가 default
	int age;
	
	public void info() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
}