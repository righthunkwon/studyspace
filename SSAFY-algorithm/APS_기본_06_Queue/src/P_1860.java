import java.util.Arrays;
import java.util.Scanner;

public class P_1860 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 손님 수
			int m = sc.nextInt(); // 붕어빵을 만들 수 있는 주기
			int k = sc.nextInt(); // 주기마다 만들 수 있는 붕어빵 개수

			// 손님이 오는 시간 배열 입력
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr); // 정렬

			
			// arr[i] / m
			// i번째 손님이 도착하는 시간을 주기로 나누어서 해당 시간까지 몇 주기가 지났는지 계산합니다. 
			// 이렇게 계산하면 현재까지 몇 번째 주기인지 알 수 있습니다.
			
			// (arr[i] / m) * k
			// 위에서 계산한 주기 수에 주기마다 만들 수 있는 붕어빵 개수 k를 곱하여, 
			// 현재까지 만들 수 있는 붕어빵 개수를 구합니다.
			
			// i + 1
			// i번째 손님에게 제공해야 할 붕어빵 개수입니다.
			
			// 따라서, 조건 arr[i] / m * k < i + 1는 
			// "현재까지 만들 수 있는 붕어빵 개수가 i번째 손님에게 제공해야 할 붕어빵 개수보다 작다면"을 나타냅니다.

			// 만약 이 조건이 참이라면, 현재까지 만들어진 붕어빵 개수가 i번째 손님에게 제공해야 할 붕어빵 개수보다 작으므로
			// 붕어빵을 모든 손님에게 제공하는 것이 불가능하다는 의미입니다. 
			// 따라서 flag를 false로 설정하여 "Impossible"을 출력하게 됩니다.

			// 반대로, 조건이 거짓이라면, 현재까지 만들어진 붕어빵 개수가 
			// i번째 손님에게 제공해야 할 붕어빵 개수보다 크거나 같다는 의미입니다. 
			// 이 경우 붕어빵을 모든 손님에게 제공하는 것이 가능하므로 
			// flag는 그대로 true로 유지되고 "Possible"을 출력하게 됩니다.

			// 즉, 이 코드는 각 손님마다 제공해야 할 붕어빵 개수와 현재까지 만들어진 붕어빵 개수를 비교하여, 
			// 모든 손님에게 붕어빵을 제공할 수 있는지 판단하는 로직을 나타냅니다.

			
			int bungeoppang = 0; // 현재 붕어빵 개수
			boolean flag = true; // 조건 판단

			for (int i = 0; i < n; i++) {
				// 붕어빵을 만들어서 i+1번째 손님에게 제공할 수 있는 붕어빵 개수가 i+1보다 작으면
				if (arr[i] / m * k < i + 1) 
					flag = false; // 붕어빵을 제공할 수 없음을 표시
			}

			// 출력
			if (flag) {
				System.out.println("#" + t + " " + "Possible");
			} else {
				System.out.println("#" + t + " " + "Impossible");
			}
		}
	}
}