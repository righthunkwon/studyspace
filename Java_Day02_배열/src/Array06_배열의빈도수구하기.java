import java.util.Arrays;

public class Array06_배열의빈도수구하기 {
	public static void main(String[] args) {
		// 배열의 빈도수 구하기
		// 수의 범위를 알고 있을 때 활용하면 좋다.
		// 값을 인덱스로 바꾸고 해당 인덱스의 값++를 해준다.
		int[] iArr = { 3, 7, 2, 5, 7, 7, 9, 2, 8, 1, 1, 5, 3 };
		int[] tmp = new int[iArr.length];

		for (int i = 0; i < iArr.length; i++) {
			tmp[iArr[i]]++;
		}
		System.out.println(Arrays.toString(tmp));
	}
}
