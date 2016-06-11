package com.hlib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hlib.domain.MemberInfo;

@Component
public class MemberInfoDAO {
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

	public MemberInfo getMemberInfo(String memberID) {
		String sqlStatement = "select * from memberinfo where MemberID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { memberID }, new MemberInfoMapper());
	}

	public List<MemberInfo> getGoodUser() {
		System.out.println("getGoodUser()");

		if (jdbcTemplateObject == null) {
			System.out.println("object == null");
		} else
			System.out.println("object != null");

		String sqlStatement = "select * from memberinfo order by MonthPoint DESC";
		return jdbcTemplateObject.query(sqlStatement, new MemberInfoMapper());
	}

	public boolean update(MemberInfo memberInfo) {
		String memberID = memberInfo.getMemberID();
		int all = memberInfo.getAllPoint();
		int month = memberInfo.getMonthPoint();
		int borrowedBook = memberInfo.getBorrowedBookCount();

		String sqlStatement = "update memberinfo set AllPoint = ?, MonthPoint = ?, BorrowedBookCount = ? where MemberID = ?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { all, month, borrowedBook, memberID }) == 1);
	}
}