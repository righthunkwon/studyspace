package src.java02.variable;

public class Var02_TypeCasting {
	
	// 자료형(Data Type)
	/*
		(1) 기본자료형(8개, byte 단위)
			: boolean(?), char(2), byte(1), short(2), int(4), long(8), float(4), double(8)
			
			- int 와 double은 기본형이다.
			- float와 double은 부동소수점 방식을 사용하기에 오차가 발생할 수 있다.
			
		(2) 참조자료형
			: String 등
			
		(3) 기본자료형에는 값이 담기고 참조자료형에는 주소가 담긴다.
		
			int age = 30;
			String name = "정훈";	
			일 경우 age에는 30이 담기지만 name에는 0x001처럼 주소가 담기고, 해당 메모리의 주소에 정훈이 담긴다.
			
	*/
	
	// 형변환
	/*
		(0) 수의 표현 범위(자료의 크기)
			: byte / short, char / int / long / float / double
		
		(1) 묵시적(암묵적, 자동) 형변환(Implicit Casting)
			: 좁 -> 넓
			: 자동으로 형변환
			
		(2) 명시적(강제적) 형변환(Explicit Casting)
			: 넓 -> 좁
			: '(타입) 값'으로 형변환
			: 데이터 손실 가능
	*/
	public static void main(String[] args) {
		// 암묵적 형변환(자동 형변환)		
		int num1 = 10000;
		long num2 = num1;
		
		// 명시적 형변환(강제 형변환)
		int num3 = 100;
		byte num4 = (byte) num3;
	}
}
