package com.hlib.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlib.dao.BookInfoDAO;
import com.hlib.dao.BorrowInfoDAO;
import com.hlib.dao.MemberInfoDAO;
import com.hlib.domain.BookInfo;
import com.hlib.domain.BorrowInfo;
import com.hlib.domain.MemberInfo;

@Service("ReturnService")
public class ReturnService {
	private MemberInfoDAO memberInfoDAO;
	private BookInfoDAO bookInfoDAO;
	private BorrowInfoDAO borrowInfoDAO;

	@Autowired
	public void setMemberInfoDAO(MemberInfoDAO memberInfoDAO) {
		this.memberInfoDAO = memberInfoDAO;
	}

	@Autowired
	public void setBookInfoDAO(BookInfoDAO bookInfoDAO) {
		this.bookInfoDAO = bookInfoDAO;
	}

	@Autowired
	public void setBorrowInfoDAO(BorrowInfoDAO borrowInfoDAO) {
		this.borrowInfoDAO = borrowInfoDAO;
	}

	public MemberInfo getMemberInfo(String memberID) {
		return memberInfoDAO.getMemberInfo(memberID);
	}

	public BookInfo getBookInfo(String ISBN) {
		return bookInfoDAO.getBookInfo(ISBN);
	}

	public BorrowInfo getBorrowInfo(String memberID, String ISBN) {
		return borrowInfoDAO.getBorrowInfo(memberID, ISBN);
	}

	public boolean returnBook(String memberID, String ISBN) {
		Date returnDate = new Date(System.currentTimeMillis());

		BorrowInfo borrowInfo = getBorrowInfo(memberID, ISBN);
		if (borrowInfo != null) {
			borrowInfo.setReturnDate(returnDate);
			borrowInfoDAO.update(borrowInfo);
			System.out.println("Update BorrowInfo.");

			MemberInfo memberInfo = getMemberInfo(memberID);

			int point = calcPoint(memberInfo.getBorrowableTerm(), borrowInfo.getBorrowDate(), returnDate); // �뿩�Ⱓ
																											// ���
			System.out.println("point = " + point);

			memberInfo.setAllPoint(memberInfo.getAllPoint() + point);
			memberInfo.setMonthPoint(memberInfo.getMonthPoint() + point);
			int borrowedBook = memberInfo.getBorrowedBookCount();
			memberInfo.setBorrowedBookCount(borrowedBook - 1);
			memberInfoDAO.update(memberInfo);
			System.out.println("update memberInfo");

			BookInfo bookInfo = getBookInfo(ISBN);
			bookInfo.setBookState(1);
			bookInfoDAO.update(bookInfo);
			System.out.println("update bookInfo");
			return true;
		}
		else {
			System.out.println("Failed to get BorrowInfo.");
			return false;
		}
	}

	public int calcPoint(int borrowableTerm, Date start, Date end) {
		long diff = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
		int days = (int)diff - borrowableTerm;
		System.out.println(diff);
		if (days > 0) {
			System.out.println("대여기간 : " + days*(-1) +"넘김, 대여가능기간 : "+ borrowableTerm);
			return (days) * (-5);
		} else {
			System.out.println("대여기간 내 반납");
			return 5;
		}
	}
}
