package test01_list;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
	// List
	// 순서 O, 중복 O, 동적 자료구조(배열 크기 변경 가능)
	// ArrayList, LinkedList, Vector

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();

		// (1) 추가
		names.add("권정훈");
		names.add("권정훈");
		names.add("박민아");
		names.add("박지원");
		names.add(0, "양명균"); // add(idx, element)
		System.out.println(names); // toString() 오버라이딩
		System.out.println(names.size()); // 길이 확인

		// (2) 비어있는지 확인
		System.out.println(names.isEmpty()); // false

		// (3) 수정
		names.set(2, "문준형");
		System.out.println(names);

		// (4) 조회
		for (String name : names) {
			System.out.println(name);
		}

		// (5) 삭제 (총 3가지)
		names.remove(0);
		System.out.println(names);

		names.remove("박민아");
		System.out.println(names);

		names.clear();
		System.out.println(names);
		System.out.println(names.isEmpty()); // true

		// (6) 전체 데이터 삭제(반복문)
		names.add("양명균");
		names.add("양명균");
		names.add("양명균");
		names.add("서만기");
		names.add("양명균");
		System.out.println(names);

		// 하나만 삭제
		names.remove("양명균");
		System.out.println(names);

		// 반복 삭제
		// size()가 계속하여 변하기 때문에 전체가 삭제되지 않는다.
//		for (int i = 0; i < names.size(); i++) {
//			if (names.get(i).equals("양명균")) {
//				names.remove(i);
//			}
//		}
//		System.out.println(names);

		// 반복삭제
		// 뒤에서부터 삭제한다.
		for (int i = names.size()-1; i >= 0; i--) {
			if (names.get(i).equals("양명균")) {
				names.remove(i);
			}
		}
		System.out.println(names);

	}
}
