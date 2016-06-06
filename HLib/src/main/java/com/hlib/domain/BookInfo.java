package com.hlib.domain;

public class BookInfo {
	private String ISBN;
	private String bookName;
	private int bookState;

	public BookInfo() {

	}

	public BookInfo(String iSBN, String bookName) {
		super();
		ISBN = iSBN;
		this.bookName = bookName;
		this.bookState = 1;		// 빌릴 수 있는 상태
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookState() {
		return bookState;
	}

	public void setBookState(int bookState) {
		this.bookState = bookState;
	}
}
