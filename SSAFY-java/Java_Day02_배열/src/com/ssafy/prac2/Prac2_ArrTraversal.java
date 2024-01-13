package com.ssafy.prac2;

import java.util.Scanner;

public class Prac2_ArrTraversal {

	public static void main(String[] args) {
		// 요구사항 1
		int[] iArr = { 2, 0, 2, 3, 0, 7, 1, 8 };
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i]);
		}

		// 요구사항 2
		Scanner sc = new Scanner(System.in);
		int foodNum = sc.nextInt();
		String[] foodList = new String[foodNum];
		
		for (int i = 0; i < foodList.length; i++) {
			foodList[i] = sc.next();
		}
		
		for (int i = 0; i < foodList.length; i++) {
			System.out.println(foodList[i]);
		}

	}

}
