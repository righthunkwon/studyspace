import java.util.Arrays;

public class Stack_06_함소호출_참조자료형 {
	public static void main(String[] args) {
		System.out.println("메인함수 실행");
		func1();
		System.out.println("메인함수 종료");
	}

	private static void func1() {
		int[] nums = { 1, 2, 3 };
		System.out.println("함수1 실행");
		func2(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println("함수1 종료");
	}

	private static void func2(int[] num) {
		System.out.println("함수2 실행");
		System.out.println("함수2 종료");
		num[0] = 999; // 배열은 참조자료형으로 메소드가 해당 주소에 접근하므로 수정이 ㅇ된다.
	}
}
