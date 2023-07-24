
public class Array07_2차원배열 {

	public static void main(String[] args) {
		// 2차원 배열의 선언
		int[][] arr1; // 권장
		int[] arr2[];
		int arr3[][];
		
		// 2차원 배열 생성
		// 배열이름 = new 배열유형[1차원배열개수][1차원배열크기];
		// 배열이름 = new 배열유형[행][열];
		// 5 * 5 사이즈의 0으로 초기화된 배열 생성
		int[][] arr4 = new int[5][5]; // (5행 5열)
		int[][] arr5 = new int[5][]; // (5형 ?열)
		System.out.println(arr5[1]); // 초기값 null
		
		// 3차원 배열
		// 배열이름 = new 배열유형[x축][y축][z축];
	}

}
