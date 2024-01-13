package com.ssafy.prac10.book;

import java.util.Arrays;
import java.util.List;

public class BookTest {
	public static void main(String[] args) {
		// save
		BookManagerImpl bm = BookManagerImpl.getManager();
//		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10);
//		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20);
//		Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30);
//		Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1);
//
//		bm.add(b1);
//		bm.add(b2);
//		bm.add(b3);
//		bm.add(m1);
//		bm.saveData();
		
		// load
		// BookManagerImpl bm = BookManagerImpl.getManager();

//		System.out.println("**********************도서 전체 목록**********************");
//		printBookList(bm.getList());
//		
//		System.out.println("**********************일반 도서 목록**********************");
//		printBookList(bm.getBooks());
//		
//		System.out.println("**********************잡지 목록**********************");
//		printBookList(bm.getMagazines());
//		
//		System.out.println("**********************도서 제목 포함검색: Java**********************");
//		printBookList(bm.searchByTitle("Java"));
//		
//		System.out.print("도서 가격 총합: " + bm.getTotalPrice());
//		System.out.println(); // 줄바꿈
//		
//		System.out.print("도서 가격 평균: " + (int) bm.getPriceAvg());
//		System.out.println(); // 줄바꿈
//		
//		System.out.println("**********************도서판매: 21424, 11개**********************");
//		try {
//			bm.sell("21424", 11);
//			System.out.println(bm.searchByIsbn("21424"));
//		} catch (ISBNNotFoundException e) {
//			e.printStackTrace();
//		} catch (QuantityException e ) {
//			
//		}
//		System.out.println("**********************도서구매: 21424, 11개**********************");
//		try {
//			bm.buy("21424", 11);
//			System.out.println(bm.searchByIsbn("21424"));
//		} catch (ISBNNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println("**********************도서판매: 21424, 11개**********************");
//		try {
//			bm.sell("21424", 11);
//			System.out.println(bm.searchByIsbn("21424"));
//		} catch (ISBNNotFoundException | QuantityException e) {
//		}
		
		
	}

	public static void printBookList(List<Book> books) {
		for (Book book : books) {
			if (book != null) {
				System.out.print(book);
			}
		}
	}
	


}
