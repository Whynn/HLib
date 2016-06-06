package com.hlib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hlib.domain.BookInfo;
import com.hlib.domain.BorrowInfo;
import com.hlib.domain.MemberInfo;

@Component
public class BookInfoDAO {
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
	public BookInfo getBookInfo(String ISBN) {
		String sqlStatement = "select * from bookinfo where ISBN=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{ISBN}, new RowMapper<BookInfo>(){
			@Override
			public BookInfo mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				BookInfo bookInfo = new BookInfo();
				
				bookInfo.setISBN(rs.getString("BookInfo_ISBN"));
				bookInfo.setBookName(rs.getString("BookName"));
				bookInfo.setBookState(rs.getInt("BookState"));
								
				return bookInfo;
			}
		});
	}
	public boolean update(BookInfo bookInfo){
		String ISBN = bookInfo.getISBN();
		int bookState = bookInfo.getBookState();
		
		String sqlStatement = "update bookinfo set BookState=? where ISBN=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{bookState, ISBN}) == 1);
	}

	public boolean insert(BookInfo bookInfo) {
		String ISBN = bookInfo.getISBN();
		String bookName = bookInfo.getBookName();
		int bookState = bookInfo.getBookState();
		
		String sqlStatement = "insert bookinfo ISBN=?, BookName=?, BookState=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{ISBN, bookName, bookState}) == 1);
	}
}
