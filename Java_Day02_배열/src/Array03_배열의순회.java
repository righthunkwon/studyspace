import java.util.Arrays;

public class Array03_배열의순회 {

	public static void main(String[] args) {
		int[] nums = { 45, 9, 3, 7, 16, 25 };

		// (1) 반복문과 .length를 통한 배열의 순회
		// 프로그래밍에서.은 앞의 요소가 가지고 있는 기능이다.
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		System.out.println("-------------------------");
		
		// (2) 향상된 for문을 통한 순회(for-each)
//		for(자료형 변수명 : 반복할 수 있는 것) {
//			
//		}
		
		// 단 향상된 for문은 읽기만 가능하다(read only)
		// 기본 for문을 통해서 값을 수정할 수 있다.
		for (int n : nums) {
			System.out.println(n);
		}
		System.out.println("-------------------------");

		// Arrays.toString(배열명);
		// 반복문을 사용하지 않더라도 배열의 값을 간단하게 출력할 수 있다.
		System.out.println(Arrays.toString(nums));
	}

}
