package com.ssafy.prac7.Book;

import java.util.Arrays;

public class BookTest {
	public static void main(String[] args) {
		BookManagerImpl bm = BookManagerImpl.getManager();
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);

		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m1);

		System.out.println("**********************도서 전체 목록**********************");
		printBookList(bm.getList());
		System.out.println("**********************일반 도서 목록**********************");
		printBooks(bm.getBooks());
		System.out.println("**********************잡지 목록**********************");
		printMagazines(bm.getMagazines());
		System.out.println("**********************도서 제목 포함검색: Java**********************");
		printTargetBook(bm.searchByTitle("Java"));
		System.out.print("도서 가격 총합: " + bm.getTotalPrice());
		System.out.println();
		System.out.print("도서 가격 평균: " + bm.getPriceAvg());

	}

	public static void printBookList(Book[] books) {
		for (Book book : books) {
			if (book != null) {
				System.out.print(book);
			}
		}
	}
	
	public static void printBooks(Book[] books) {
		for (Book book : books) {
			if (book != null) {
				System.out.print(book);
			}
		}
	}

	public static void printMagazines(Magazine[] magazines) {
		for (Magazine magazine : magazines) {
			if (magazine != null) {
				System.out.print(magazine);
			}
		}
	}
	
	public static void printTargetBook(Book[] books) {
		for (Book book : books) {
			if (book != null) {
				System.out.print(book);
			}
		}
	}

}
