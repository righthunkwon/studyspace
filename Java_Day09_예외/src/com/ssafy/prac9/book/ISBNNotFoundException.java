package com.ssafy.prac9.book;

public class ISBNNotFoundException extends Exception {
	private String isbn;

	public ISBNNotFoundException(String isbn) {
		super();
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}
	
}
