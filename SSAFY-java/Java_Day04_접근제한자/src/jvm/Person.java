package jvm;

public class Person {
	// 클래스 변수
	// 모든 인스턴스가 공유
	// 클래스 영역에 생성
	static int pCount;
	
	// 인스턴스 변수
	// 인스턴스마다 메모리 할당(heap메모리)
	String name;
	String hobby;
	int age;
	
	// non-static
	// static이 먼저 만들어져 있으므로 pCount 사용 가능
	public void count() {
		System.out.println(pCount);
	}
	
	// static
	// static은 미리 메모리에 올라가 있으므로 
	// 아직 생성되지 않은 non-static한 name, hobby, age는 사용 불가
	public static void info() {
		// System.out.println(name); // 사용 불가
	}
}
