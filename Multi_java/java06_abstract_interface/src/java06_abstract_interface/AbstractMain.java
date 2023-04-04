package java06_abstract_interface;

	/*
			추상 클래스 
				: 일반 메서드와 추상 메서드를 가진 클래스
				: 추상 클래스는 추상 메서드가 하나 이상 포함된 클래스
				: 추상 메서드는 메서드명만 존재하고 실행부({} 내부)를 명시하지 않은 미완성 메서드를 의미
				: 추상 메서드는 반환형 왼쪽에 abstract 키워드를 표기해야 한다.
				: 추상 클래스 역시 class 키워드 왼쪽에 abstract 키워드를 표기해야 한다.
	*/
public abstract class AbstractMain { // 추상 클래스 AbstractTest (추상 메서드가 하나 이상 포함된 클래스)
	// 생성자 메서드
	public AbstractMain() {
		
	}
	// 일반 메서드(합, 정수 두 개를 매개변수로 전달 받은 뒤, 합을 구해 콘솔에 찍는 메서드)
	public void add(int a, int b) { 
		int hap = a + b;
		System.out.println(a+"+"+b+"="+hap);
	}
	// 추상 메서드
	public abstract void minus(int a, int b);
	
	// 일반 메서드(곱)
	public void multiple(int x, int y) {
		int mul = x * y;
		System.out.println(x+"*"+y+"="+mul);
	}
	
	// 추상 메서드
	public abstract void divide(int x, int y);
}

















