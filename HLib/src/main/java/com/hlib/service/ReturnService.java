package com.hlib.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

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
	
	public void returnBook(String memberID, String ISBN) {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd"); // ���� ��¥�� ���ϱ� ����
		//String ss = sdf.format(new java.util.Date()); // ���� ��¥
		Date returnDate = new Date(System.currentTimeMillis());

		BorrowInfo borrowInfo = getBorrowInfo(memberID, ISBN);

		borrowInfo.setReturnDate(returnDate);				// ���� ��¥ ����
		borrowInfoDAO.update(borrowInfo); 						// �뿩 �̷� ����
		System.out.println("Update BorrowInfo.");

		MemberInfo memberInfo = getMemberInfo(memberID);
		
		int point = calcPoint(memberInfo.getBorrowableTerm(), borrowInfo.getBorrowDate(), returnDate);	// �뿩�Ⱓ ���
		
		memberInfo.setAllPoint(memberInfo.getAllPoint() + point);
		memberInfo.setMonthPoint(memberInfo.getMonthPoint() + point);
		memberInfo.setBorrowedBookCount(memberInfo.getBorrowedBookCount() - 1);
		memberInfoDAO.update(memberInfo);						// ȸ������ ����
		
		BookInfo bookInfo = getBookInfo(ISBN);
		bookInfo.setBookState(1);
		bookInfoDAO.update(bookInfo);							// �������� ����
	}
	public int calcPoint(int borrowableTerm, Date start, Date end){
		if(end.compareTo(start) > borrowableTerm){
			return -5;
		}
		else{
			return 5;
		}
	}
	/*
	 * public List<Member> get(){ return memberInfoDAO.getMemberInfo(); }
	 */
}
