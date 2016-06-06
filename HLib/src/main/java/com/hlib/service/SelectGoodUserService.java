package com.hlib.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hlib.domain.MemberInfo;
import com.hlib.dao.MemberInfoDAO;

@Service("SelectGoodUserService")
public class SelectGoodUserService {
	private MemberInfoDAO memberInfoDAO;

	@Autowired
	public void setMemberInfoDAO(MemberInfoDAO memberInfoDAO) {
		this.memberInfoDAO = memberInfoDAO;
	}

	public List<MemberInfo> select() {
		List<MemberInfo> memberList = memberInfoDAO.getGoodUser(); // 내림차순 정렬된 리스트
		
		int size = 5;
		if (memberList.size() < 5) {
			size = memberList.size();
		}
		List<MemberInfo> selectedUser = null;
		for (int i = 0; i < size; i++){				// 최대 10명까지만 출력하려고..
			selectedUser.add(memberList.get(i));
		}
		return selectedUser;
	}
}
