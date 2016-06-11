package com.hlib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlib.dao.BookInfoDAO;
import com.hlib.domain.BookInfo;

@Service("CheckService")
public class CheckService {

	private BookInfoDAO bookInfoDAO;
	private BookInfo bookInfo;
	
	@Autowired
	public void setBookInfoDAO(BookInfoDAO bookInfoDAO) {
		this.bookInfoDAO = bookInfoDAO;
	}
	
	public void setBookInfo() {
		
	}
	
	public void setBookInfo(String ISBN) {
		this.bookInfo = bookInfoDAO.getBookInfo(ISBN);
	}
	
	public String getBookName() {
		return bookInfo.getBookName();
	}
	
}
