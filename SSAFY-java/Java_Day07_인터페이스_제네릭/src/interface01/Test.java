package interface01;

public class Test {
	public static void main(String[] args) {
		// 인터페이스는 객체 생성 불가 (단, 익명클래스 활용 시 가능)
		// MyInterface i = new MyInterface(); 
		
		MyClass mc = new MyClass();
		mc.method1();
		mc.method2();
		System.out.println(mc.MEMBER1);
		System.out.println(mc.MEMBER2);
	}
}
