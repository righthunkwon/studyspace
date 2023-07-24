package com.ssafy.prac5;

public class BookManager {
	private static final int MAX_SIZE = 100;
	private static Book[] bookList = new Book[MAX_SIZE];
	private int size = 0;
	private static BookManager bm = new BookManager();

	private BookManager() {
	}

	public static BookManager getManager() {
		return bm;
	}

	public void add(Book book) {
		if (size < MAX_SIZE) {
			bookList[size] = book;
			size++;
		}
	}
	
	public void remove(String isbn) {

	}
}
