
public class 분할정복_01_분할하지않는_거듭제곱 {
	public static void main(String[] args) {
		int base = 2;
		int exponent = 10;
		
		// 거듭제곱을 구하는 메소드
		System.out.println(power(base, exponent));
	}
	
	private static int power(int base, int exponent) {
		// 기저부분(종료조건)
		if (exponent == 0) {
			return 1;
		}
		
		// 재귀부분(반복수행)
		return base * power(base, exponent - 1);
	}
}
