package com.shinhan.controller3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/getcookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cs = request.getCookies();
		for(Cookie cookie:cs) {
			if(cookie.getName().equals("JSESSIONID")) continue;
			out.println("<h1>쿠키이름: " + cookie.getName() + "</h1>");
			out.println("<h2>쿠키값: " + cookie.getValue() + "</h2>");
		}
		
		
		
	}

}
