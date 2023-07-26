package test08_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest2 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();

		list.add(new Person("권정훈", "980617"));
		list.add(new Person("권정훈", "990617"));
		list.add(new Person("권정훈", "960617"));
		list.add(new Person("권정훈", "970617"));

		// 나이가 많은 순서대로 정렬
		// Comparator 인터페이스를 구현한 AgeComparator 클래스의 compare 메소드에서 정의한 기준
		// 익명 내부 클래스 활용 가능
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.parseInt(o1.id) - Integer.parseInt(o2.id);
			}
		});
		System.out.println(list);
	}
}
