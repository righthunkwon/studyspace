package com.ssafy.prac4;

public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book();
		book1.isbn = "21424";
		book1.title = "Java Pro";
		book1.author = "김하나";
		book1.publisher = "jaen.kr";
		book1.price = 15000;
		book1.desc = "Java 기본 문법";
		
		Book book2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		
		System.out.println("**********************도서목록**********************");
		System.out.println(book1.toString());
		System.out.println(book2.toString());
	}
}
