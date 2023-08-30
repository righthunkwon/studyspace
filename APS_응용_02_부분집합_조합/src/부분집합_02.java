import java.util.Arrays;

public class 부분집합_02 {
	public static void main(String[] args) {
		int n = 4;
		int[] sel = new int[n];
		String[] ingredients = { "참치", "스팸", "돈까스", "제육" };
		
		// 부분집합
		// 1 << n = 16
		// 반복문의 i는 0부터 15까지의 수로 이진수로 표현했을 때 앞서 살펴본 부분집합의 구성과 동일. 즉, i는 모든 부분집합
		// 비트 연산자 : & (둘 다 1이면 1, 하나라도 0이면 0)
		for (int i = 0; i < (1<<n); i++) {
			System.out.println("부분집합의 번호: " + i);
			
			// 재료 검사
			for (int j = 0; j < n; j++) {
				
				// 비트연산 << 의 횟수
				if ((i & (1<<j)) > 0) {
					System.out.print(ingredients[j] + " ");
				}
			}
			System.out.println("김밥");
		}

	}
}
