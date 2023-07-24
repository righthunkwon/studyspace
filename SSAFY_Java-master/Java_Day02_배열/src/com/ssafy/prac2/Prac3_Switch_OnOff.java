package com.ssafy.prac2;

import java.util.Arrays;
import java.util.Scanner;

public class Prac3_Switch_OnOff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N+1];

		for (int i = 1; i <= M; i++) {
			double input = sc.nextDouble();
			for (int j = 1; j <= N; j++) {
				if (j % input == 0) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else if (arr[j] == 1) {
						arr[j] = 0;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
