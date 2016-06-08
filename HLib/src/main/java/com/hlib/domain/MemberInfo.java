package com.hlib.domain;

import java.text.Collator;
import java.util.Comparator;

public class MemberInfo {
	private String MemberID;
	private int BorrowableTerm;
	private int MonthPoint;
	private int AllPoint;
	private int BorrowedBookCount;
	private int BorrowableBookCount;
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

	public MemberInfo(String MemberID, int BorrowableTerm, int MonthPoint, int AllPoint, int BorrowedBookCount,
			int BorrowableBookCount) {
		super();
		this.MemberID = MemberID;
		this.BorrowableTerm = BorrowableTerm;
		this.MonthPoint = MonthPoint;
		this.AllPoint = AllPoint;
		this.BorrowedBookCount = BorrowedBookCount;
		this.BorrowableBookCount = BorrowableBookCount;
	}

	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String memberID) {
		MemberID = memberID;
	}

	public int getBorrowableTerm() {
		return BorrowableTerm;
	}

	public void setBorrowableTerm(int borrowableTerm) {
		BorrowableTerm = borrowableTerm;
	}

	public int getMonthPoint() {
		return MonthPoint;
	}

	public void setMonthPoint(int monthPoint) {
		MonthPoint = monthPoint;
	}

	public int getAllPoint() {
		return AllPoint;
	}

	public void setAllPoint(int allPoint) {
		AllPoint = allPoint;
	}

	public int getBorrowedBookCount() {
		return BorrowedBookCount;
	}

	public void setBorrowedBookCount(int borrowedBookCount) {
		BorrowedBookCount = borrowedBookCount;
	}

	public int getBorrowableBookCount() {
		return BorrowableBookCount;
	}

	public void setBorrowableBookCount(int borrowableBookCount) {
		BorrowableBookCount = borrowableBookCount;
	}

	
}
