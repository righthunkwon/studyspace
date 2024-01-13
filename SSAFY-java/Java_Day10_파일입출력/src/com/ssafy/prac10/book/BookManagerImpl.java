package com.ssafy.prac10.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.prac10.movie.Movie;

public class BookManagerImpl implements IBookManager {
	private static final int MAX_SIZE = 100;
	private int size = 0;

	private static List<Book> bookList = new ArrayList<Book>();
	private static BookManagerImpl bm = new BookManagerImpl();

	private BookManagerImpl() {
		loadData();
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
		for (int i = 0; i < bookList.size(); i++) {
			sum += (bookList.get(i)).getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		return getTotalPrice() / (double) bookList.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		for (int i = 0; i < bookList.size(); i++) {
			if ((bookList.get(i)).getIsbn() == null) {
				throw new ISBNNotFoundException(isbn);
			}
			if ((bookList.get(i)).getQuantity() - quantity <= 0 ) {
				System.out.println("수량이 부족합니다.");
				throw new QuantityException();
			}
			if ((bookList.get(i)).getIsbn() == isbn) {
				int stock = (bookList.get(i)).getQuantity();
				stock -= quantity;
				(bookList.get(i)).setQuantity(stock);
			}
		}
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for (int i = 0; i < bookList.size(); i++) {
			if ((bookList.get(i)).getIsbn() == null) {
				throw new ISBNNotFoundException(isbn);
			}
			if ((bookList.get(i)).getIsbn() == isbn) {
				int stock = (bookList.get(i)).getQuantity();
				stock += quantity;
				(bookList.get(i)).setQuantity(stock);
			}
		}
	}

	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"))) {
			oos.writeObject(bookList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadData() {
		File file = new File("book.dat");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"))) {
				Object obj = ois.readObject();
				System.out.println(obj);
				bookList = (List<Book>) obj;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
