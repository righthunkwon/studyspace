package com.ssafy.prac9.book;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private static final int MAX_SIZE = 100;
	private int size = 0;

	private static List<Book> bookList = new ArrayList<Book>();
	private static BookManagerImpl bm = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static BookManagerImpl getManager() {
		return bm;
	}

	public void add(Book book) {
		if (bookList.size() < MAX_SIZE) {
			bookList.add(book);
		} else if (bookList.size() == MAX_SIZE) {
			System.out.println("책은 100개 까지만 등록할 수 있습니다.");
		}
	}

	public void remove(String isbn) {
		for (int i = 0; i < bookList.size(); i++) {
			if ((bookList.get(i)).getIsbn() == isbn) {
				bookList.remove(i);
				break;
			}
		}
	}

	public List<Book> getList() {
		return bookList;
	}

	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < bookList.size(); i++) {
			if ((bookList.get(i)).getIsbn() == isbn) {
				return bookList.get(i);
			}
		}
		return null;
	}

	public List<Book> searchByTitle(String title) {
		List<Book> result = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			if ((bookList.get(i)).getTitle().contains(title)) {
				result.add(bookList.get(i));
			}
		}
		return result;
	}

	public List<Book> getMagazines() {
		List<Book> result = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i) instanceof Magazine) {
				result.add(bookList.get(i));
			}
		}
		return result;
	}

	public List<Book> getBooks() {
		List<Book> result = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			if (!(bookList.get(i) instanceof Magazine)) {
				result.add(bookList.get(i));
			}
		}
		return result;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += (bookList.get(i)).getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		return getTotalPrice() / (double) this.size;
	}

}
