package test02.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SequentialSearch2 {
	
	// 선형검색(for문 활용)
	static int linearSearch(int arr[], int n, int key) {
		for(int i=0; i<n; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		// 요소수 입력
		System.out.print("요소 수: ");
		int n = scan.nextInt();
		int arr[] = new int[n]; 
		
		// 1~20까지의 수를 요소수만큼 생성하여 배열에 저장
		for(int i=0; i<arr.length; i++) {
			arr[i] = ran.nextInt(20)+1; // ran.nextInt(20)은 0이상, 20미만이므로 1~20의 범위를 주기 위해서는 +1을 해주어야 한다. 
		}
		
		System.out.print("검색할 값: ");
		int key = scan.nextInt();
		
		int index = linearSearch(arr, n, key);
		if(index==-1) {
			System.out.println("검색한 값이 존재하지 않습니다.");
		} else {
			System.out.println("검색한 값의 index는 " + index + "이고, 값은 "+ arr[index] + "입니다.");
		}
		System.out.print("배열 확인: ");
		System.out.println(Arrays.toString(arr));
	}

}
