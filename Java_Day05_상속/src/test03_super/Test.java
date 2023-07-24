package test03_super;

public class Test {
	public static void main(String[] args) {
		// heap 메모리에 Object 객체 생성 - Person 객체 생성(부모) - Student 객체 생성(자식)
		Student st = new Student("권정훈", 28, "스페인어전공");
		System.out.println(st.age);
		st.study();
		System.out.println(st.age);
	}
}
