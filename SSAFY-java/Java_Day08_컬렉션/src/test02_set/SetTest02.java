package test02_set;

import java.util.HashSet;
import java.util.Set;

import test07_comparable.Person;

public class SetTest02 {
	public static void main(String[] args) {
		// HashSet
		// 내부적으로 hash값을 기준으로 판단한 뒤, equals를 돌린다.
		// 따라서 오버라이드를 할 때도 hashCode()를 먼저 작성한 뒤 equals()를 이후에 작성하는 것이 좋다.
		
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("안준현", "970301"); // heap에 p1 생성
		Person p2 = new Person("안준현", "970301"); // heap에 p2 생성
		
		set.add(p1);
		set.add(p2);
		
		// hashCode()나 equals()를 재정의하지 않고서는 두 명의 안준현이 들어오고, 두 객체의 해시값이 다르게 출력된다.
		System.out.println(set);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}
