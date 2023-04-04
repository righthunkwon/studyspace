package test02.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthGraphicsUtils;

public class BinarySearch {
	
	/*
		이진검색 
			: 데이터가 오름차순 혹은 내림차순으로 정렬되어 있을 때 가능
			: 트리에서 자주 활용
			: 중앙값을 구하여 중앙값이 찾는 값보다 작으면 오른쪽으로, 찾는 값보다 크면 왼쪽으로 검색(이진검색 = 이분검색)
			: pl(왼쪽 시작 index), pr(오른쪽 끝 index), pc(중앙 위치 index)
			: 선형검색보다 검색 처리 속도가 빠르지만 데이터의 집합이 반드시 정렬되어 있어야 한다
			  (이렇게 이야기하면 얼마나 빠른지 감이 잘 안올텐데, 가령 70억명의 사람중 한 사람을 찾으려고 한다면, 
			   선형검색은 Worst Case의 경우 70억번, 대략적으로 생각해도 35억번은 비교연산을 해야 하는데, 
			   이진 검색은 최대 33번의 비교만으로도 원하는 데이터를 찾을 수 있다.)
			
	*/  
	static int binarySearch(int arr[], int n, int key) {
		int pl = 0; // pl (시작 index)
		int pr = n-1; // pr (끝 index)
		
		do {
			int pc = (pl + pr) / 2 ; // pc (중앙 index)
			if(arr[pc]==key) {
				return pc;
			} else if(arr[pc] < key ) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while(pl<=pr);
		
		// 검색 값이 없을 때
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		System.out.print("요소 수: ");
		int n = scan.nextInt();
		
		int arr[] = new int[n];
		
		// 값 생성
		for(int i=0; i<arr.length; i++) {
			arr[i] = ran.nextInt(100)+1;
		}
		
		// 정렬
		Arrays.sort(arr); // 오름차순(기본값)
		System.out.println(Arrays.toString(arr));
		
		// 검색할 값 입력
		System.out.print("검색할 값: ");
		int key = scan.nextInt();
		
		int index = binarySearch(arr, n, key);
		if(index==-1) {
			System.out.println("검색한 값이 존재하지 않습니다.");
		} else {
			System.out.println("arr["+index+"]="+arr[index]);
		}
	}

}
