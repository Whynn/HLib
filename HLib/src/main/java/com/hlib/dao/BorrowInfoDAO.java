package com.hlib.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hlib.domain.BorrowInfo;
import com.hlib.domain.MemberInfo;

@Component
public class BorrowInfoDAO {
	private JdbcTemplate jdbcTemplateObject;
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from memberinfo";
		return this.jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}
	public BorrowInfo getBorrowInfo(String memberID, String ISBN) {
		String sqlStatement = "select * from borrowinfo where MemberInfo_MemberID = ? and BookInfo_ISBN = ? and ReturnDate = null";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{memberID, ISBN}, new BorrowInfoMapper());
	}
	public boolean insert(BorrowInfo borrowInfo){
		Date borrowDate = borrowInfo.getReturnDate();
		String ISBN = borrowInfo.getBookInfo_ISBN();
		String memberID = borrowInfo.getMemberInfo_MemberID();
		
		String sqlStatement = "insert borrowinfo BookInfo_ISBN = ?, MemeberInfo_MemberID = ?, BorrowedDate = ?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{ISBN, memberID, borrowDate}) == 1);
	}
	public boolean update(BorrowInfo borrowInfo){
		Date returnDate = borrowInfo.getReturnDate();
		String ISBN = borrowInfo.getBookInfo_ISBN();
		String memberID = borrowInfo.getMemberInfo_MemberID();
		
		String sqlStatement = "update borrowinfo set ReturnDate = ? where MemberInfo_MemberID = ? and BookInfo_ISBN = ?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{returnDate, memberID, ISBN}) == 1);
	}
}
