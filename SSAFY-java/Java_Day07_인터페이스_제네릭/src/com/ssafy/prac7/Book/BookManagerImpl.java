package com.ssafy.prac7.Book;

public class BookManagerImpl implements IBookManager {
	private static final int MAX_SIZE = 100;
	private int size = 0;

	private static Book[] books = new Book[MAX_SIZE];
	private static BookManagerImpl bm = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static BookManagerImpl getManager() {
		return bm;
	}

	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size] = book;
			size++;
		}
	}

	public void remove(String isbn) {
		Book[] newBooks = new Book[size - 1];
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn() == isbn) {
				idx = i;
				cnt++;
				for (int j = 0, k = 0; j < newBooks.length; j++) {
					if (j != idx) {
						newBooks[k] = books[i];
						k++;
					}
				}
			} else if (cnt == 0) {
				System.out.println("해당 책은 존재하지 않습니다.");
			}
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
			if (books[i].getTitle().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

	public Book[] searchByTitle(String title) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (books[i].getTitle().contains(title)) {
				cnt++;
			}
		}

		Book[] result = new Book[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (books[i].getTitle().contains(title)) {
				result[idx] = books[i];
				idx++;
			}
		}
		return result;
	}

	public Magazine[] getMagazines() {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (books[i] instanceof Magazine) {
				cnt++;
			}
		}

		if (cnt == 0) {
			return null;
		}

		Magazine[] mg = new Magazine[cnt];

		for (int i = 0, idx = 0; i < this.size; i++) {
			if (books[i] instanceof Magazine) {
				mg[idx++] = (Magazine) books[i];
			}
		}
		return mg;
	}

	public Book[] getBooks() {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}

		if (cnt == 0) {
			return null;
		}

		Book[] b = new Book[cnt];

		for (int i = 0, idx = 0; i < this.size; i++) {
			if (!(books[i] instanceof Magazine)) {
				b[idx++] = books[i];
			}
		}
		return b;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		return getTotalPrice() / (double) this.size;
	}
	
	
}

