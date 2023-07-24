package com.ssafy.prac6;

public class Magazine extends Book{
	private int year;
	private int month;
	
	public Magazine() {
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle()
				+ ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice()
				+ ", getDesc()=" + getDesc() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
