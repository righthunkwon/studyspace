package test06_extends;

class Parent {
	int data = 10;
	public void print() {
		System.out.println(data);
	}
}

class Child extends Parent {
	int data = 20;
	public void print() {
		int data = 30;
		System.out.println(data); // 30
		System.out.println(this.data); // 20
		System.out.println(super.data); // 10
	}
}

public class ExtendsTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.print(); // 30, 20, 10
		
		Parent p = new Child();
		p.print(); // 10 X / 30, 20, 10 O (동적 바인딩)
		// 참조변수는 변수타입을 따르지만, 참조된 메소드는 항상 오버라이드된 자식클래스의 메소드가 실행된다.
		// 즉, 상속관계에서 멤버변수가 중복이 되면 참조 변수의 타입을 따르지만,
		// 메소드가 중복될 때는 무조건 자식 클래스의 메소드가 호출된다. 
	} 
}
