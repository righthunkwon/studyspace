package com.ssafy.prac5;

public class BookManager {
	private static final int MAX_SIZE = 100;
	private int size = 0;

	private static Book[] books = new Book[MAX_SIZE];
	private static BookManager bm = new BookManager();

	private BookManager() {
	}

	public static BookManager getManager() {
		return bm;
	}

	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size] = book;
			size++;
		}
	}

	public void remove(String isbn) {
		int idx = -1; // 삭제할 책의 index
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn() == isbn) {
				idx = i;
				break;
			}
		}
		
		if (idx == -1) {
			System.out.println("해당 책은 존재하지 않습니다.");
		} else {
			Book[] newBooks = new Book[size - 1];
			int cnt = 0; // 새 배열의 index
			for (int i = 0; i < size; i++) { // 원래 배열만큼 반복하되,
				if (i != idx) { // 만약 i가 idx와 같지 않다면 새배열에 기존 배열을 추가함으로써 remove target no count
					newBooks[cnt] = books[i];
					cnt++;
				}
			}
			books = newBooks; // 새 배열을 기존 배열에 담는다.
			size--; // 배열의 사이즈를 하나 줄인다.
		}
	}

	public Book[] getList() {
		Book[] result = new Book[size];
		for (int i = 0; i < size; i++) {
			result[i] = books[i];
		}
		return result;
	}

	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < this.size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}

