import java.util.Arrays;

public class 부분집합_01 {
	public static void main(String[] args) {
		int n = 4;
		int[] sel = new int[n];
		String[] ingredients = { "참치", "스팸", "돈까스", "제육" };
		
		// 부분집합
		// n개 원소의 부분집합의 개수는 각 원소가 포함되는지 되지 않는지에 따라 경우의 수가 나누어지므로 2^n개이다.
		for (int a = 0; a < 2; a++) {
			sel[0] = a;
			for (int b = 0; b < 2; b++) {
				sel[1] = b;
				for (int c = 0; c < 2; c++) {
					sel[2] = c;
					for (int d = 0; d < 2; d++) {
						sel[3] = d;
						System.out.println(Arrays.toString(sel));
						for (int i = 0; i < n; i++) {
							if (sel[i] == 1) {
								System.out.print(ingredients[i] + " ");
							}
						}
						System.out.println("김밥");
					}
				}
			}
		}
	}
}
