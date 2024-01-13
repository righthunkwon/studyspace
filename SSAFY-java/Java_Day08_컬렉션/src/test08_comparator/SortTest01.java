package test08_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest01 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();

		list.add(new Person("권정훈", "980617"));
		list.add(new Person("권정훈", "990617"));
		list.add(new Person("권정훈", "960617"));
		list.add(new Person("권정훈", "970617"));

		// 나이가 많은 순서대로 정렬
		// Comparator 인터페이스를 구현한 AgeComparator 클래스의 compare 메소드에서 정의한 기준
		Collections.sort(list, new AgeComparator());
		System.out.println(list);

		
	}
}
