package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
	public static void main(String[] args) {
		// HashSet
		// 해시 테이블에 원소를 저장
		// 원소들의 순서가 일정하지 않다
		Set<String> set = new HashSet<String>();
		set.add("박지원");
		set.add("유승호");
		set.add("이건희");
		set.add("안준현");
		set.add("안준현");
		System.out.println(set);
		
		// 해시값이 동일할 경우 equals()는 true
		// 하지만 해시값이 같은 게 반드시 두 객체의 동일성을 담보하지는 않는다.
		// 해시값이 다르면 반드시 다르지만, 해시값이 같더라도 같지는 않을 수 있다.
		System.out.println("박지원".hashCode());
		System.out.println("박지원".hashCode());
	}
}

