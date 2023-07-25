package interface01;

public interface MyInterface {
	// 모든 변수는 상수
	// public static final 자동 삽입(생략 가능)
	public static final int MEMBER1 = 10;
	int MEMBER2 = 20; // int MEMBER2의 앞에도 public static final이 생략되어 있다.
	
	// 모든 메소드는 추상 메소드
	// public abstract 자동 삽입(생략 가능)
	public abstract void method1();
	void method2(); // void method2()앞에도 public abstract가 생략되어 있다.
}
