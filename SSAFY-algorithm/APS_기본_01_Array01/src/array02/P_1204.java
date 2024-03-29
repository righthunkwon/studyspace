package array02;

import java.util.Scanner;

public class P_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			sc.nextInt(); // test case 입력

			// 1000명의 학생들의 점수를 나타낸 도수분포표 배열
			int[] scoresCnt = new int[101]; // 0 ~ 100점(101 크기의 배열)
			for (int i = 0; i < 1000; i++) {
				scoresCnt[sc.nextInt()]++;
			}

			int max = 0; // 최빈값
			int idx = 0; // 최빈값의 인덱스
			
			// 빈도가 동일할 경우 큰 점수 부터 찾기 위해 역순으로 탐색
			for (int i = 100; i >= 0; i--) { 
				if (scoresCnt[i] > max) { // 최빈값 찾기
					max = scoresCnt[i]; // 빈도수 저장
					idx = i; // 최빈값 점수
				}
			}

			System.out.printf("#%d %d\n", t, idx);
		}
	}
}
