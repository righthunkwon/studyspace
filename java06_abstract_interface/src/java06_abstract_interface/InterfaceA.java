package java06_abstract_interface;

	/*
			인터페이스(interface)
				: 자식 클래스가 여러 부모 클래스를 상속받을 수 있다면, 다양한 동작을 수행할 수 있다는 장점을 가질 것이다. 
				  하지만 클래스를 이용하여 다중 상속을 할 경우 메소드 출처의 모호성 등 여러 가지 문제가 발생할 수 있어 
				  자바에서는 클래스를 통한 다중 상속은 지원하지 않는다.
				  
				  그러나 다중 상속의 이점을 버릴 수는 없기에 자바에서는 인터페이스라는 것을 통해 다중 상속을 지원한다.
				  인터페이스(interface)란 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 
				  다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스를 의미한다.
				  
				  자바에서 추상 클래스는 추상 메소드뿐만 아니라 생성자, 필드, 일반 메소드도 포함할 수 있지만, 
				  인터페이스(interface)는 오로지 추상 메소드와 상수만을 포함할 수 있다. 
				  
				  (추상클래스 : 일반메서드, 추상메서드, 생성자, 필드)
				  (인터페이스 : 추상메서드, 상수)
				  
				 
			인터페이스 선언
				: 자바에서 인터페이스를 선언하는 방법은 클래스를 작성하는 방법과 같다.
				  인터페이스를 선언할 때에는 접근 제어자와 함께 interface 키워드를 사용하면 된다.
				: 단, 클래스와는 달리 인터페이스의 모든 필드는 public static final이어야 하며, 
				  모든 메소드는 public abstract이어야 한다.

						접근제어자 interface 인터페이스이름 {
						    public static final 타입 상수이름 = 값;
						    ...
						    public abstract 메소드이름(매개변수목록);
						    ...
						}


			인터페이스 구현
				: 인터페이스는 추상 클래스와 마찬가지로 자신이 직접 인스턴스를 생성할 수는 없다.
				  따라서 인터페이스가 포함하고 있는 추상 메소드를 구현해 줄 클래스를 작성해야 한다.
				  또한, 만약 모든 추상 메소드를 구현하지 않는다면, abstract 키워드를 사용하여 추상 클래스로 선언해야 한다.
				
						class 클래스이름 implements 인터페이스이름 { ... }
	*/


public interface InterfaceA extends InterfaceB {
	// 상수
	public static final int MAX = 100;
	public static final String FIRST_NAME = "LEE";
	
	// 추상메서드
	public int hap(int x, int y);
	public int cha(int x, int y);
	public int gob(int x, int y);
	public int mok(int x, int y);
	
}
