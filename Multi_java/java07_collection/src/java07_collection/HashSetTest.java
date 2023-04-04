package java07_collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	double data[] = {12.5, 56.3, 9.6, 41.2, 10.9, 12.5, 56.3, 9.6, 41.2, 10.9};
	public HashSetTest() {
		
	}
	public void start() {
		/*
				 HashSet
				 	: Set 인터페이스를 상속받음
				 	: 저장 순서를 유지하지 않는다.
				 	: 중복 데이터를 허용하지 않는다.
		*/
		
		HashSet<Double> hs = new HashSet<Double>();
		// 반복문을 이용하여 HashSet에 객체 추가
		for(double d : data) {
			hs.add(d);  
		}
		
		// HashSet 객체 꺼내기
		Iterator<Double> i = hs.iterator();
		while(i.hasNext()) { // 객체가 있으면 true, 없으면 false가 리턴되는 메소드
			double num = i.next();
			System.out.print(num + "\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		HashSetTest hst = new HashSetTest();
		hst.start();
	}

}
	
	/*
			next()와 hasNext()
			
				: 둘 다 Iterator 인터페이스의 메서드로 자주 사용됨
				: Iterator에 추가적인 요소가 있을 때 가져오는 역할
				: 둘은 반환 타입에서 차이를 보임
				: hasNext()는 boolean 타입으로 반환(값이 있으면 true, 없으면 false)
				: next()는 매개변수 혹은 iterator 된느 타입으로 반환, 즉 아무 타입으로 반환 가능
	*/
