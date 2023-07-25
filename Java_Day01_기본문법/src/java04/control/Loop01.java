package src.java04.control;

public class Loop01 {
	public static void main(String[] args) {
		// for (초기화; 조건식; 증감식) { 반복내용 }
		// 초기화식은 반복문이 시작될 때 한 번 실행된다.
		// 조건식이 false이면 반복문이 종료된다.
		// 초기화식과 증감식은 ,를 이용하여 둘 이상 작성할 수 있다.
		// 조건식을 비워두면 항상 참으로 인식해서 무한루프가 발생한다.
		// 반복 횟수를 알고 있을 때 사용하면 좋다.
		
		for (int i = 2; i <= 9; i++) {
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
		}
	}
}
