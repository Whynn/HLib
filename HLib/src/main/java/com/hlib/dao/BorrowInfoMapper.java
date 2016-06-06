package com.hlib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hlib.domain.BorrowInfo;

public class BorrowInfoMapper implements RowMapper<BorrowInfo> {
	@Override
	public BorrowInfo mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		BorrowInfo borrowInfo = new BorrowInfo();

		borrowInfo.setBookInfo_ISBN(rs.getString("BookInfo_ISBN"));
		borrowInfo.setBorrowDate(rs.getDate("BorrowDate"));
		borrowInfo.setMemberInfo_MemberID(rs.getString("MemberInfo_MemberID"));
		borrowInfo.setReturnDate(rs.getDate("ReturnDate"));

		return borrowInfo;
	}
}
