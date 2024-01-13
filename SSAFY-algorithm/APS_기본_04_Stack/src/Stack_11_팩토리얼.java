
public class Stack_11_팩토리얼 {
	public static void main(String[] args) {
		// 5! = 5 * 4!
		// 4! = 4 * 3!
		// ...
		// n! = n * (n-1)!
		System.out.println(fact(4)); // 24
		System.out.println(fact(5)); // 120
		
	}
	
	// 팩토리얼은 반복문을 통해서도 나타낼 수 있고, 반복문으로 구현하는 것이 더 간단할 수 있다.
	// 하지만 재귀함수는 여러 분기가 있을 때 재귀함수의 진수를 느낄 수 있다. 지금은 연습해본다고 생각하자.
	private static int fact(int n) {
		// 기본부분
		if (n == 1) {
			return 1;
			
		// 재귀부분
		} else {
			return n * fact(n - 1);
		}
	}
}
