package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/addcart.do")
public class CartServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/addCart.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		int count = Integer.parseInt(request.getParameter("count"));	// 신규개수
		
		Cookie[] cs = request.getCookies();
		int cnt = 0;
		for(Cookie cookie:cs) {
			if(product.equals(cookie.getName())) {
				cnt = Integer.parseInt(cookie.getValue());	// 기존 개수
				break;
			}
			
		}
		if(!(product.equals("no"))) {
		Cookie newcookie = new Cookie(product, count+cnt+"");
		newcookie.setMaxAge(24*60*60); 	// 유효시간 설정
		response.addCookie(newcookie);
		}
		response.sendRedirect("addcart.do");
		
		
	}

}
