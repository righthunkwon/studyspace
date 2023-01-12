package java07_collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		
	}
	public void start() {
		String data[] = {"자바", "java", "Java", "스프링", "spring", "에이잭스", "ajax", "1234", "자바", "spring"};
		
		/*
			TreeSet 컬렉션
				: 저장 순서를 유지하지 않는다.
				: 정렬된다.(기본: 오름차순)
				: 중복을 허용하지 않는다.
		*/ 
		TreeSet<String> ts = new TreeSet<String>();
		
		for(int i=0; i<data.length; i++) {
			ts.add(data[i]);
		}
		System.out.println("객체 수 : "+ts.size()); // 8, 중복된 데이터 2개는 제거되었다.
		
		
		// 오름차순으로 정리하여 Iterator 객체로 리턴해준다.
		Iterator<String> ii = ts.iterator();
		while(ii.hasNext()) {
			System.out.println(ii.next()+"\t"); // 숫자 -> 영어대문자 -> 영어소문자 -> 한글 순으로 정리
		}
		System.out.println();
		
		
		// 내림차순으로 정렬하여 Iterator 객체로 리턴해준다.
		Iterator<String> iii = ts.descendingIterator();
		while(iii.hasNext()) {
			System.out.println(iii.next() +"\t");
		}
		System.out.println();
		
		
		// 가장 앞에 있는 데이터 꺼내기
		String first = ts.first();
		System.out.println("first : "+first); // 이미 오름차순으로 정렬되어 1234가 출력
	}
	public static void main(String[] args) {
		TreeSetTest tst = new TreeSetTest();
		tst.start();
	}

}
