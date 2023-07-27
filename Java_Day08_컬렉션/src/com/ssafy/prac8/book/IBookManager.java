package com.ssafy.prac8.book;

import java.util.List;

public interface IBookManager {
	void add(Book book);
	
	void remove(String isbn);
	
	List<Book> getList();
	
	Book searchByIsbn(String isbn);
	
	List<Book> searchByTitle(String title);
	
	List<Book> getMagazines();
	
	List<Book> getBooks();
	
	int getTotalPrice();
	
	double getPriceAvg();
}
