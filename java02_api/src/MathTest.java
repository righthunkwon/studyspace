
public class MathTest {

	public MathTest() {
		
	}
	public static void main(String[] args) {
		/*
			java.lang.Math클래스(기본 클래스)
			
				Math.ceil			: 올림
				Math.floor			: 버림
				Math.round			: 반올림
				Math.abs()			: 절댓값 반환
				Math.sqrt*(			: 제곱근 반환
				Math.pow(밑, 지수)	: 제곱연산 수행
				Math.random()		: 0.0~1.0 사이의 임의의 double형 데이터 반환(난수)
				Math.max(int a, int b)	: 최댓값 
				Math.max(int a, int b)	: 최솟값
		*/
		
		System.out.println(Math.ceil(5.1)); // 6, double
		System.out.println((int)Math.ceil(5.1)); // 6, int
		System.out.println(Math.ceil(-5.1)); // -5, double
		
		long n1 = Math.round(5.1); // 5, long : double은 round 했을 때 long으로 넘어감 (float를 round했을 때 int로 넘어감) 
		System.out.println(n1);
		
		int n2 = Math.round((float)5.1);
		System.out.println(n2); // 5, int
	}

}
