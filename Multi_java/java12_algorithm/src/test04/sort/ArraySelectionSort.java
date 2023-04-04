package test04.sort;

	/*
		선택정렬(SelectionSort)
			: 제자리정렬 알고리즘의 하나로, 주어진 데이터 중 제일 작은 값을 찾아 기준위치의 값과 교환하는 정렬방법
			: 오름차순을 기준으로 정렬
			: 입력배열(정렬되지 않은 값들) 이외에 다른 추가 메모리를 요구하지 않음
			: 해당 순서에 원소를 넣을 위치는 이미 정해져있고, 어떤 원소를 넣을지 선택하는 알고리즘
			
			
			과정 
				1. 주어진 배열 중에서 최솟값을 찾는다.
				2. 그 값을 맨 앞에 위치한 값과 교체한다(패스(pass)).
				3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
				4. 하나의 원소만 남을 때까지 위의 1~3 과정을 반복한다.
	*/

public class ArraySelectionSort {

	public static void main(String[] args) {
		int arr[] = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("=============== 정렬 전 ===============");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println( );
		
		for(int point=0; point<arr.length-1; point++) { // 마지막 배열의 값은 기준위치이므로 arr.length에 -1을 해준다.
			int minIndex = point; // 가장 작은 값을 가진 index
			
			// 기준점 다음 위치부터 끝까지 비교
			for(int j=point+1; j<arr.length; j++) {
				// minIndex와 j번째의 값을 비교해서 j번째가 minIndex의 값보다 작으면 j를 minIndex에 대입
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			
			// point위치의 값과 min위치의 값을 교환
			int temp = arr[point];
			arr[point] = arr[minIndex];
			arr[minIndex] = temp;
			
			System.out.println("============= "+(point+1)+"번 정렬 후 ============== ");
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+"  ");
			}
			System.out.println();
		}

	}

}
