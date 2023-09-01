import java.util.Scanner;

// https://st-lab.tistory.com/250
// 백만 개의 정수 정렬
// 퀵 정렬
public class S_14229_quick {
	private static int[] arr;
	private static int[] sortarr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1000000;
		arr = new int[n];
		sortarr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		pivotSort(arr, 0, arr.length - 1);
		System.out.println(arr[500000]);
	}

	private static void pivotSort(int[] arr, int lo, int hi) {

		// lo가 hi보다 크거나 같다면
		// 정렬할 원소가 1개 이하이므로 정렬하지 않고 return
		if (lo >= hi) {
			return;
		}

		// 파티셔닝
		int pivot = partition(arr, lo, hi);

		// 재귀호출(분할정복)
		pivotSort(arr, lo, pivot - 1);
		pivotSort(arr, pivot + 1, hi);
	}

	private static int partition(int[] arr, int left, int right) {
		int lo = left;
		int hi = right;
		int pivot = arr[left]; // 부분리스트의 왼쪽 요소를 피벗으로 설정

		// hi가 lo보다 클 때까지만 반복
		while (lo < hi) {

			// hi가 lo보다 크면서
			// hi의 요소가 pivot보다 작은 요소를 찾을 때까지 hi를 감소시키며 이를 반복
			while (arr[hi] > pivot && lo < hi) {
				hi--;
			}

			// hi가 lo보다 크면서
			// lo의 요소가 pivot보다 크거나 같은 원소를 찾을 때까지 lo를 증가시키며 이를 반복
			while (arr[lo] <= pivot && lo < hi) {
				lo++;
			}

			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
			swap(arr, lo, hi);
		}

		// 마지막으로 맨 처음 pivot으로 설정했던 위치(arr[left])의 원소와 lo가 가리키는 원소를 바꾼다.
		swap(arr, left, lo);

		// 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 lo를 반환한다.
		return lo;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}