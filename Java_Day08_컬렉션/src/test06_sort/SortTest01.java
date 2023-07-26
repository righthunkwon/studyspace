package test06_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest01 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();

		names.add("박민아");
		names.add("권정훈");
		names.add("박지원");
		names.add("나건웅");
		names.add("하재률");
		System.out.println(names); // 정렬 X
		
		Collections.sort(names);
		System.out.println(names); // 정렬 O

		// 컬렉션의 정렬	: Collections.sort()
		// 배열의 정렬	 	: Arrays.sort()
		
		// 정렬의 기준
		// (1) Comparable interface (나와 얘를 비교) : 양수면 자리를 바꾸고, 음수나 0이면 자리를 유지시킨다.
		// (2) Comparator (얘와 쟤를 비교) : 
	}
}
