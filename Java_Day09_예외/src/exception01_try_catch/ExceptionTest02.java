package exception01_try_catch;

public class ExceptionTest02 {
	public static void main(String[] args) {
		int[] nums = { 10 };

		try {
			System.out.println(nums[2]);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("배열의 인덱스 범위를 벗어났습니다.");
			System.out.println("============================");
			System.out.println(aiobe.getMessage());
			System.out.println("============================");
			System.out.println(aiobe.toString());
			System.out.println("============================");
			aiobe.printStackTrace();
		}
	}
}
