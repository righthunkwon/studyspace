package test04_overriding;

public class Test {
	public static void main(String[] args) {
		// heap 메모리에 Object 객체 생성 - Person 객체 생성(부모) - Student 객체 생성(자식)
		Student st = new Student();
		st.eat();
	}
}
