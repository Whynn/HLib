package com.hlib.domain;

import java.text.Collator;
import java.util.Comparator;

public class MemberInfo {
	private String memberID;
	private int borrowableTerm;
	private int monthPoint;
	private int allPoint;
	private int borrowedBookCount;
	private int borrowableBookCount;
	/*
	private final static Comparator myComparator = new Comparator(){
		private final Collator collator = Collator.getInstance();

		@Override
		public int compare(MemberInfo o1, MemberInfo o2) {
			return collator.compare(o1.getAllPoint(), o2.getAllPoint());
		}
	};*/

	public MemberInfo() {

	}

	public MemberInfo(String memberID, int borrowableTerm, int monthPoint, int allPoint, int borrowedBookCount,
			int borrowableBookCount) {
		super();
		this.memberID = memberID;
		this.borrowableTerm = borrowableTerm;
		this.monthPoint = monthPoint;
		this.allPoint = allPoint;
		this.borrowedBookCount = borrowedBookCount;
		this.borrowableBookCount = borrowableBookCount;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getBorrowableTerm() {
		return borrowableTerm;
	}

	public void setBorrowableTerm(int borrowableTerm) {
		this.borrowableTerm = borrowableTerm;
	}

	public int getMonthPoint() {
		return monthPoint;
	}

	public void setMonthPoint(int monthPoint) {
		this.monthPoint = monthPoint;
	}

	public int getAllPoint() {
		return allPoint;
	}

	public void setAllPoint(int allPoint) {
		this.allPoint = allPoint;
	}

	public int getBorrowedBookCount() {
		return borrowedBookCount;
	}

	public void setBorrowedBookCount(int borrowedBookCount) {
		this.borrowedBookCount = borrowedBookCount;
	}

	public int getBorrowableBookCount() {
		return borrowableBookCount;
	}

	public void setBorrowableBookCount(int borrowableBookCount) {
		this.borrowableBookCount = borrowableBookCount;
	}
}
