import java.util.Scanner;

// https://st-lab.tistory.com/233
// 백만 개의 정수 정렬
// 병합정렬
public class S_14229_merge {
	private static int[] arr;
	private static int[] sortarr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1000000;
		arr = new int[n];
		sortarr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(arr, 0, arr.length-1);
		System.out.println(arr[500000]);
	}
	
	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sortarr[idx++] = arr[L++];
			} else {
				sortarr[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortarr[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				sortarr[idx++] = arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = sortarr[i];
		}

	}
}
