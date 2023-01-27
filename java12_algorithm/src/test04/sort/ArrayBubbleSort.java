package test04.sort;

import java.util.Random;

	/*
		버블정렬(BubbleSort)
			: 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘(오름차순/내림차순 모두 가능)
			: 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.
			: 가령, 오름차순으로 정렬할 경우 왼쪽 값이 오른쪽 값보다 작아야 한다. 
			  이때 전체적으로 한 번 정렬할 경우 가장 왼쪽에 최솟값이 나타나고,
			  두 번째 정렬할 경우 그 오른쪽에 다음 작은 값이 나타난다.
			  따라서, 시간복잡도는 O(n^2)이 된다.
			  
			장점
				구현이 간단하다
				이미 정렬된 데이터를 정렬할 때 속도가 빠르다.
				
			단점
				다른 정렬에 비해 속도가 느리다. (역순배열을 정렬할 때 가장 느리다)
				일반적으로 자료의 교환 작업(SWAP)이 자료의 이동 작업(MOVE)보다 더 복잡하기 때문에 
				버블 정렬은 단순성에도 불구하고 거의 쓰이지 않는다.
			
	*/

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// 난수를 생성하여 배열에 저장 후 버블정렬을 통해 오름차순으로 정렬하기
		Random ran = new Random();
		int arr[] = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = ran.nextInt(100)+1;
		}
		
		System.out.println("==========정렬 전==========");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1) {
				System.out.print(", ");
			} else if(i<arr.length) {
				
			}
		}
		
		System.out.println();
		System.out.println("==========정렬 후==========");
		// 버블 정렬
		for(int k=0; k<arr.length-1; k++) {
			for(int i=0; i<arr.length-1-k; i++) { // 버블정렬에서 마지막은 정렬할 수 없고 또 필요도 없으므로 arr.length에 -1을 해준다. 
				                                  // 또한, -k를 해줌으로써 불필요한 회전수를 줄일 수 있다.(이미 정렬된 곳은 불필요하게 또 정렬할 필요가 없기 때문! - 생각해보기)
				if(arr[i] > arr[i+1]) { // <-- 오름차순 (내림차순은 부등호 반대)
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
	
		// 정렬 이후 출력
		for(int j=0; j<arr.length; j++) {
			System.out.print(arr[j]);
			if(j != arr.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
