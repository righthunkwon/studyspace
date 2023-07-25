package interface01;

// 인터페이스를 구현하는 구현 클래스
// 인터페이스는 그 자체로는 인스턴스를 생성할 수 없기 때문에
// 구현 클래스를 활용하여 인스턴스를 생성한다.
public class MyClass implements MyInterface {

	@Override
	public void method1() {
		System.out.println("method1() 실행");
	}

	@Override
	public void method2() {
		System.out.println("method2() 실행");
	}

}
