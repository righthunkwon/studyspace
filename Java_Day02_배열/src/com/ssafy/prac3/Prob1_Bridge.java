package com.ssafy.prac3;

import java.util.Scanner;

public class Prob1_Bridge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[N][N];

		// 지도 정보 입력 받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 최대값 저장
		int maxDistance = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 지금 위치가 섬인지 검사
				if (map[i][j] == 1) {

					// 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장

					// 북쪽이 1인지 검사
					for (int d = 1; i - d > 0; d++) {
						if (map[i - d][j] == 1) {
							maxDistance = Math.max(d, maxDistance);
							break;
						}
					}

					// 남쪽이 1인지 검사
					for (int d = 1; i + d < N; d++) {
						if (map[i + d][j] == 1) {
							maxDistance = Math.max(d, maxDistance);
							break;
						}
					}

					// 서쪽이 1인지 검사
					for (int d = 1; j - d > 0; d++) {
						if (map[i][j - d] == 1) {
							maxDistance = Math.max(d, maxDistance);
							break;
						}
					}

					// 동쪽이 1인지 검사
					for (int d = 1; j + d < N; d++) {
						if (map[i][j + d] == 1) {
							maxDistance = Math.max(d, maxDistance);
							break;
						}
					}
				}
			}
		}

		System.out.println(maxDistance);

	}// main
}
