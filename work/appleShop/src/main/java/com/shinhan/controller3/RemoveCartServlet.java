package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/removecart.do")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		
		String path = request.getContextPath();
		response.sendRedirect(path + "/viewcart2.do");
		//session.invalidate(); // 저장된 모든 Attribute 지우기
		
	}


}
