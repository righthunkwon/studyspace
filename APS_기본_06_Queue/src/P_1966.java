import java.util.Scanner;

// 숫자를 정렬하자
public class P_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			// 배열에 요소 넣기
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 버블 정렬(n-1의 사이클, 오름차순으로 정렬할 경우 뒤쪽 요소는 계속 i만큼 정렬할 필요가 없어진다)
			for (int i = 0; i < n - 1; i++) {
				for (int j = 1; j < n - i; j++) {
					if (arr[j - 1] > arr[j]) {
						int tmp = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = tmp;
					}
				}
			}
			
			System.out.printf("#%d ", t);
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
