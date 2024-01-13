
import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 41, 22 };

		// 삽입정렬 구현
		// 0은 이미 정렬되어 있다고 볼 수 있으므로 index는 1부터 설정
		for (int i = 1; i < data.length; i++) { // cycle : data.length - 1
			int key = data[i]; // 이번에 정렬할 값
			int j;

			// 넣을 위치를 찾고 위치가 바뀌면 요소를 뒤로 미는 반복문
			// 뒤에서부터 하면 더 가까우므로 뒤에서부터 접근하는 게 좋다.
			for (j = i - 1; j >= 0 && key < data[j]; j--) {
				data[j + 1] = data[j];
			}
			data[j+1] = key;
			System.out.println(Arrays.toString(data));
		}
	}
}
