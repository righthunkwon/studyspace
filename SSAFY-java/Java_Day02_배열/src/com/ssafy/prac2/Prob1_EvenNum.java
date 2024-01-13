package com.ssafy.prac2;

import java.util.Arrays;
import java.util.Scanner;

public class Prob1_EvenNum {
	public static void main(String[] args) {
		// 요구사항 1
		int[] iArr = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		System.out.println("-----원소 10개 출력-----");
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		
		// 요구사항 2
		System.out.println("-----원소 10개 중 짝수만 출력-----");
		for (int i = 0; i < iArr.length; i++) {
			if (iArr[i] % 2 == 0) {
				System.out.print(iArr[i] + " ");
			}
		}
		System.out.println();
		
		// 요구사항 3
		Scanner sc = new Scanner(System.in);
		System.out.println("-----바꿀 위치 입력 : ");
		int idx = sc.nextInt();
		System.out.println("-----수 입력 : ");
		int num = sc.nextInt();
		iArr[idx] = num;
		System.out.println("-----원소 10개 출력-----");
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	}
}
