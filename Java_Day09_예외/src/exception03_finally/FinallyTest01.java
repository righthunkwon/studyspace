package exception03_finally;

public class FinallyTest01 {
	public static void main(String[] args) {
		int num = 1;
		try {
			System.out.println("1");
			
			// (1) 정상 실행 : 1 2 4 5
			// int i = 1 / num; 
			
			// (2) 예외 발생(예외 처리) : 1 3 4 5
			// int i = 1 / 0; 
			
			// (3) 예외 발생(예외 미처리) : 1 4
			// int[] nums = {1};
			// nums[2] = 10; 
			
			System.out.println("2");
			
			// (4) return : 1 2 4
			// return;
		} catch (ArithmeticException e) {
			System.out.println("3");
			// (4) return : 1 3 4
			// finally는 return이 나와도 무조건 실행
			// return;
		} finally {
			System.out.println("4");
		}
		System.out.println("5");
	}
}
