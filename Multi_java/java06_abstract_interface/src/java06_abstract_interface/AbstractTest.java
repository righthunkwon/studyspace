package java06_abstract_interface;
	
	/*
			추상 클래스 사용하기
				: 추상 클래스는 반드시 extends로 상속받아야 한다.
				: 상속 받은 추상클래스의 모든 클래스를 오버라이딩 해야 한다.
				: 추상 클래스는 미완성 클래스이기 때문에 new로 객체를 생성하여 사용할 수 없다. (따라서 상속받아야 한다)
				
	*/
public class AbstractTest extends AbstractMain {


	public AbstractTest() {
		
	}

	// 추상 메서드 오버라이딩
	// 반환형, 메서드명, 매개변수 갯수, 매개변수 데이터형이 일치해야 한다.
	public void minus(int x, int y) {
		int result = Math.abs(x - y); // abs() : 절댓값
		System.out.println(x+"-"+y+"="+result);
	}
	public void divide(int x, int y ) {
		
	}

	public static void main(String[] args) {
		AbstractTest at = new AbstractTest();
		at.add(5, 7);
		at.minus(5, 12);
		at.divide(2, 3);
	}

}
	
	/*  
	 
			오버로딩
				: 같은 이름의 메서드 여러 개를 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
				: 자바의 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메서드가 있더라도
				  매개변수의 개수 또는 타입이 다르면 같은 이름을 사용해서 메소드를 정의할 수 있는데,
				  이를 오버로딩이라 한다.
				: 오버로딩을 이용하면 같은 기능을 하는 메소드를 하나의 이름으로 사용할 수 있고,
				  메소드의 이름을 절약할 수 있다는 장점이 있다.
				
				
			오버라이딩
				: 상위 클래스가 가지고 있는 메서드를 하위 클래스가 재정의해서 사용
				: 상위 클래스가 가지고 있는 멤버 변수가 하위 클래스로 상속되는 것처럼
				  상위 클래스가 가지고 있는 메서드도 하위 클래스로 상속되어 하위 클래스에서 사용 가능.
				: 하위 클래스에서 메서드를 재정의해서 사용 가능
				
				: 오버라이딩은 부모 클래스의 메소드를 재정의하는 것을 의미한다.
				: 오버라이딩은 부모 클래스의 메소드를 재정의하므로, 자식 클래스에서는
				  오버라이딩하고자 하는 메소드의 이름, 매개변수, 리턴값이 모두 일치해야 한다.
		
			
			요약
			1. 오버로딩(Overloading)
				- over + load = 과적하다, 많이 싣다
				- 메서드의 이름은 같고 매개변수의 갯수나 타입이 다른 함수를 정의하는 것을 의미한다.
				- 리턴값만을 다르게 갖는 오버로딩은 작성 할 수 없다.
	
			2. 오버라이딩(Overriding)
				- over + ride =  위에서 달린다, 탄다
				- 상위 클래스의 메서드를 하위 클래스가 재정의 하는 것이다.
				- 메서드의 이름은 물론 파라메터의 갯수나 타입도 동일해야 하며, 
				  주로 상위 클래스의 동작을 상속받은 하위 클래스에서 변경하기 위해 사용된다.
				
	
				즉,
				오버로딩(Overloading)은 기존에 없던 새로운 메서드를 정의하는 것이고,
				오버라이딩(Overriding)은 상속 받은 메서드의 내용만 변경 하는 것이다.
	
								오버로딩 오버라이딩 
				메소드 이름	|	동일		동일
				매개변수		|	다름		동일
				리턴 타입		|	상관없음	동일


	*/