package binary_search;
import java.util.Arrays;
import java.util.Scanner;

// 나무자르기
public class P_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 나무의 수
		int m = sc.nextInt(); // 나무의 길이
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		// 10 15 17 20
		// 7 -> 15
		
		int st = 0; // 시작점
		int ed = arr.length - 1; // 종료점

		int ans = 0; // 절단기 높이의 최대값
		
	}
}
