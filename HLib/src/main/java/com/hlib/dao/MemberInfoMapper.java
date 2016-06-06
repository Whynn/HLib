package com.hlib.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hlib.domain.MemberInfo;

public class MemberInfoMapper implements RowMapper<MemberInfo> {
	@Override
	public MemberInfo mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setMemberID(rs.getString("memberID"));
		memberInfo.setAllPoint(rs.getInt("AllPoint"));
		memberInfo.setMonthPoint(rs.getInt("MonthPoint"));
		memberInfo.setBorrowableBookCount(rs.getInt("BorrowedBookCount"));
		memberInfo.setBorrowedBookCount(rs.getInt("BorowableBookCount"));
		memberInfo.setBorrowableTerm(rs.getInt("BorrowableTerm"));
		
		return memberInfo;
	}
}
