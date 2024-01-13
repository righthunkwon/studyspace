package src.java03.operator;

public class Op05_삼항연산자 {
	// 삼항연산자
	// 조건식 ? 식1(참) : 식2(거짓)
	
	public static void main(String[] args) {
		// 랜덤 숫자 발생기
		// 0.0 <= Math.random() < 1.0
		// 1 ~ 10까지의 무작위 수
		int num = (int) (Math.random() * 10) + 1; 
		System.out.println(num);
		
		// 삼항연산자를 활용한 짝홀수 판별
		// 삼항연산자는 중첩하여 사용하는 것을 권장하지 않는다.
		System.out.println(num % 2 == 0 ? "짝" : "홀");
	}
}
