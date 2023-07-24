package com.ssafy.prac6;

import java.util.Arrays;

public class BookTest {
	public static void main(String[] args) {
		BookManager bm = BookManager.getManager();
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);

		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m1);
		
		System.out.println(Arrays.toString(bm.getList()));
	}
}

