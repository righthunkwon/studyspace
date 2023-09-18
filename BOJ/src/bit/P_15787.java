package bit;

import java.util.Scanner;

// 비트마스크
// 존재를 1로, 존재하지 않음을 0으로 표현
// 즉, 비트마스크는 이진수를 이용하여 두 가지 정보를 표현하는 것

// 비트마스크의 상태를 변경하기 위한 다양한 연산은
// 비트연산으로 효율적으로 구현 가능한데, 이것이 비트마스크를 사용하는 이유

// 기본
// & : and
// | : or
// ^ : xor
// ~ : not
// <<, >>, >>> : shift

// 응용
// 가장 우측의 비트를 1번째 비트라고 할 때,
// i번째 비트 조회는 n & (1 << (i - 1)) 

// 기차가 어둠을 헤치고 은하수를
// 사람이 있음을 1로, 없음을 0으로 표현


// 링크 확인
// https://haerang94.tistory.com/428
public class P_15787 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 기차의 수
		int m = sc.nextInt(); // 명령의 수
		int ans = 0; // 어둠을 헤치고 은하수를 건넌 기차
		int[][] train = new int[n][20]; // 20칸의 좌석을 가진 n개의 기차

		int order = 0;
		for (int i = 0; i < m; i++) {
			order = sc.nextInt();
			int j = 0; // 기차 번호
			int x = 0; // 좌석 번호

			switch (order) {
			case 1: // j번째 기차의 x번째 좌석에 사람을 태운다.
				// 좌석은 1번부터 시작하지만 좌석의 인덱스는 0번부터 시작하므로 -1
				j = sc.nextInt();
				x = sc.nextInt() - 1;
				train[j][x] = 1;
				break;

			case 2: // j번째 기차의 x번째 좌석에 앉은 사람은 하차한다.
				// 좌석은 1번부터 시작하지만 좌석의 인덱스는 0번부터 시작하므로 -1
				j = sc.nextInt();
				x = sc.nextInt() - 1;
				train[j][x] = 0;
				break;

			case 3: // j번째 기차에 앉아있는 승객들은 모두 한 칸씩 뒤로 간다(마지막 사람은 하차).
				j = sc.nextInt();
				for (int k = 18; j >= 0; j--) {
					train[j][k + 1] = train[j][k];// 뒤로 옮기기
				}
				train[j][0] = 0;
				break;

			case 4: // j번째 기차에 앉아있는 승객들은 모두 한 칸씩 앞으로 한다(맨 앞 사람은 하차).
				j = sc.nextInt();
				for (int k = 1; k < 20; k++) {
					train[j][k - 1] = train[j][k];
				}
				train[j][19] = 0;
				break;
			}
		}
	}
}
