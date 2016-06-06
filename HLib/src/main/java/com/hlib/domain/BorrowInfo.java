package com.hlib.domain;

import java.sql.Date;

public class BorrowInfo {
	private Date borrowDate;
	private Date returnDate;
	private String bookInfo_ISBN;
	private String memberInfo_MemberID;

	public BorrowInfo() {

	}

	public BorrowInfo(Date borrowDate, Date returnDate, String bookInfo_ISBN, String memberInfo_MemberID) {
		super();
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.bookInfo_ISBN = bookInfo_ISBN;
		this.memberInfo_MemberID = memberInfo_MemberID;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookInfo_ISBN() {
		return bookInfo_ISBN;
	}

	public void setBookInfo_ISBN(String bookInfo_ISBN) {
		this.bookInfo_ISBN = bookInfo_ISBN;
	}

	public String getMemberInfo_MemberID() {
		return memberInfo_MemberID;
	}

	public void setMemberInfo_MemberID(String memberInfo_MemberID) {
		this.memberInfo_MemberID = memberInfo_MemberID;
	}
}