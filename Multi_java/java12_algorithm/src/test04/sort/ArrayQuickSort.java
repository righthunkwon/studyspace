package test04.sort;

public class ArrayQuickSort {
	/*
		퀵정렬(QuickSort)
			: 퀵정렬은 불안정정렬의 하나로, 다른 원소와의 비교만으로 정렬을 수행한다.
			: 분할 정복 알고리즘의 하나로, 평균적으로 매우 빠른 수행 속도를 자랑하는 정렬 방법이다.
			
			과정
				1. 리스트 안에 있는 한 요소를 선택한다. 이렇게 고른 원소를 피벗(pivot) 이라고 한다.
				2. 피벗을 기준으로 피벗보다 작은 요소들은 모두 피벗의 왼쪽으로 옮겨지고 피벗보다 큰 요소들은 모두 피벗의 오른쪽으로 옮겨진다. 
				   (피벗을 중심으로 왼쪽: 피벗보다 작은 요소들, 오른쪽: 피벗보다 큰 요소들)
				3. 피벗을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다.
				4. 분할된 부분 리스트에 대하여 순환호출을 이용하여 정렬을 반복한다.
				5. 부분 리스트에서도 다시 피벗을 정하고 피벗을 기준으로 2개의 부분 리스트로 나누는 과정을 반복한다.
				6. 부분 리스트들이 더 이상 분할이 불가능할 때까지 반복한다.
				7. 리스트의 크기가 0이나 1이 될 때까지 반복한다.
	*/
	
	static void quickSort(int arr[], int left, int right ) {
		int pointLeft = left; // 왼쪽위치 0
		int pointRight = right; // 오른쪽위치 9
		int pivot = (left+right)/2; // 피벗 4
		
		int x = arr[pivot];
		
		do {
			// 왼쪽에서 피벗보다 큰값의 위치 찾기
			while(arr[pointLeft] < x) {
				pointLeft++;
			}
			
			// 오른쪽에서 피벗보다 작은값의 위치 찾기
			while(arr[pointRight] > x) {
				pointRight--;
			}
			
			// pointLeft 위치의 값과 pointRight 위치의 값을 교환(메소드)
			if(pointLeft <= pointRight) {
				swap(arr, pointLeft, pointRight);
				pointLeft++;
				pointRight--;
			}
		} while(pointLeft <= pointRight);
		
		// 재귀호출
		if(left<pointRight) {
			quickSort(arr, left, pointRight);
		}
		if(pointLeft<right) {
			quickSort(arr, pointLeft, right);
		}
	}
	
	static void swap(int arr[], int pointLeft, int pointRight) {
		int temp = arr[pointLeft];
		arr[pointLeft] = arr[pointRight];
		arr[pointRight] = temp;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("============ 정렬 전 ============");
		for(int d : arr) {
			System.out.print(d+"  ");
		}
		System.out.println();

		
		// 퀵정렬
		quickSort(arr, 0, arr.length-1); // (데이터, 왼쪽끝, 오른쪽끝)
		
		System.out.println("============ 정렬 후 ============");
		for(int d : arr) {
			System.out.print(d+"  ");
		}
		System.out.println();
	
	
	
	}
	


}
