
public class 분할정복_03_이진검색_재귀 {
	// 이진검색을 위한 정렬된 배열
	private static int key;
	private static int[] arr;

	public static void main(String[] args) {
		key = 7;
		arr = new int[] { 2, 4, 7, 9, 11, 19, 23 };
		
		System.out.println(binarySearch(0, arr.length-1));
	}

	private static boolean binarySearch(int st, int ed) {
		// 기저부분(종료조건)
		if (st > ed) {
			return false;
		}

		int mid = (st + ed) / 2;

		// 재귀부분(반복수행)
		if (key == arr[mid]) {
			return true;
		} else if (key < arr[mid]) {
			return binarySearch(st, mid - 1);
		} else {
			return binarySearch(mid + 1, ed);
		}
	}

}
