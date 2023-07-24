package test03_super;

public class Person {
	String name;
	int age;
	
	// 기본 생성자 별도로 생성
	public Person() {
		System.out.println("Person의 기본 생성자입니다.");
	}
	
	// 파라미터가 있는 생성자 (이를 생성할 경우 기본 생성자는 따로 정의해주지 않으면 사용 불가)
	public Person(String name) {
		super(); // Object의 기본 생성자 호출(Person은 별도로 부모가 없기에 가장 상위인 Object 클래스를 부모로 둔다) 
		this.name = name;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.println("음식을 먹는다.");
	}
	
}
