import java.util.Arrays;

public class CopyDeep {
	public static void main(String[] args) {
		// 깊은 복사
		// 1차원배열 - 반복문, arr.clone(), Arrays.copyof()
		// 2차원배열 - 반복문 only
		int[] a = { 1, 2, 3 };
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		b[2] = 100;
		a[1] = 200;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		

	}
}
