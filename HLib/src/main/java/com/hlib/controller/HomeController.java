package com.hlib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hlib.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private HomeService homeService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	@RequestMapping(value = "/")
	public String home(Locale locale, HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {		// 처음에 접속할때 null뜨는 것을 넘어가려고 try - catch 문을 삽입
			String ID = request.getParameter("ID");
			String PW = request.getParameter("PW");
			System.out.println(ID);
			System.out.println(PW);

			if (!homeService.isManager(ID, PW)) {
				try {
					response.setContentType("text/html;charset=utf-8;");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('잘못된 ID, PW입니다.');</script>");
					out.flush();
					System.out.println("alert()");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return "manager";
			}
		} catch (NullPointerException e) {

		}
		return "home";
	}

}
