package com.hlib.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hlib.domain.MemberInfo;
import com.hlib.service.SelectGoodUserService;

@Controller
public class SelectGoodUserController {
	private SelectGoodUserService selectGoodUserService;

	public void setSelectGoodUserService(SelectGoodUserService selectGoodUserService) {
		this.selectGoodUserService = selectGoodUserService;
	}
	@RequestMapping(value="/select", method = RequestMethod.GET)
	public String Home(HttpServletRequest request, Model model) {
		System.out.println("/select");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<MemberInfo> memberList = selectGoodUserService.select();
		model.addAttribute("members", memberList);
		
		return "select";
	}
}
