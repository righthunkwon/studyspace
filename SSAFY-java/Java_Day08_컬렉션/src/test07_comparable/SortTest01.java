package test07_comparable;

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
		// Person 클래스의 compareTo() 메소드에서 정의한 기준
		Collections.sort(list);
		System.out.println(list);

		
	}
}
