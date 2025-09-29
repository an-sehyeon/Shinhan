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
 * Servlet implementation class CartViewServlet
 */
@WebServlet("/viewcart.do")
public class CartViewServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<ul>");
		
		Cookie[] cs = request.getCookies();

		for(Cookie cookie:cs) {
			if(cookie.getName().equals("JSESSIONID") || cookie.getName().equals("subject")) continue;
			out.print("<li>" + cookie.getName() + " ==> " +cookie.getValue() + "</li>");
		}
		out.print("</ul>");
	}

}
