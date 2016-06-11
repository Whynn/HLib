package com.hlib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hlib.domain.BookInfo;
import com.hlib.domain.BorrowInfo;
import com.hlib.domain.MemberInfo;
import com.hlib.service.CheckService;
import com.hlib.service.ReturnService;

@Controller
public class ReturnController {
	private ReturnService returnService;
	private CheckService checkService;

	// IReturn iReturn;
	@Autowired
	public void setReturnService(ReturnService returnService) {
		this.returnService = returnService;
	}
	
	@Autowired
	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String ReturnRequest(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("/returnRequest");

		return "request";
	}

	@RequestMapping(value = "/return")
	public String Return(HttpServletRequest request, HttpServletResponse response, Model model) {
		// log
		System.out.println("return()");
		boolean result = false;
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String memberID = request.getParameter("memberID");
		String ISBN = request.getParameter("ISBN");
		System.out.println(memberID);
		System.out.println(ISBN);
		try {
			result = returnService.returnBook(memberID, ISBN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result){
			
			checkService.setBookInfo(ISBN);
			String bookName = checkService.getBookName();
			
			model.addAttribute("memberID", memberID);
			model.addAttribute("bookName", bookName);
			
			System.out.println("memberID : " + memberID);
			System.out.println("bookName : " + bookName);
			
			return "check";
		}
		else{
			try {
				response.setContentType("text/html;charset=utf-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('대여정보를 불러오지 못했습니다.');</script>");
				out.flush();
				System.out.println("alert()");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "request";
		}
	}

	@RequestMapping(value = "/check")
	public String ReturnCheck(HttpServletRequest request, Model model) {
		System.out.println("returnCheck()");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String memberID = request.getParameter("memberID");
		String ISBN = request.getParameter("ISBN");

		model.addAttribute("Request", request);

		return "redirect:home";

	}
}