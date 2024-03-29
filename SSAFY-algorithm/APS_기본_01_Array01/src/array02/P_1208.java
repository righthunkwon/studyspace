package array02;

import java.util.Scanner;

public class P_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// test case
		for (int t = 1; t <= 10; t++) {
			// dump num
			int dump = sc.nextInt();

			// input box arr
			int[] arr = new int[100]; 
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			
			// variables
			int max = 0, maxIdx = 0, min = 101, minIdx = 0;
			
			// dumping
			for (int i = 0; i < dump; i++) {
				for (int j = 0; j < 100; j++) {
					// max & maxIdx
					if (max < arr[j]) {
						max = arr[j];
						maxIdx = j;
					}
					// min & minIdx
					if (min > arr[j]) {
						min = arr[j];
						minIdx = j;
					}
				}
				// finish dump
				if (max - min <= 1) {
					break;
				}
				// do dump
				arr[maxIdx]--;
				arr[minIdx]++;
				
				// reset value
				max = 0;
				min = 101;
			}

			// max & min
			for (int i = 0; i < 100; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			System.out.printf("#%d %d\n", t, max - min);
		}
	}
}
