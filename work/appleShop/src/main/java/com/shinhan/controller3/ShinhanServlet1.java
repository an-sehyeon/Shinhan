package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 요청주소 ==> http://localhost:9090/appleShop/one
 * 응답주소 ==> http://localhost:9090/appleShop/jsp/one.jsp
 * forward는 주소창이 변경되지않는다. 즉 request가 유지된다.
 * 
 */
@WebServlet("/one")
public class ShinhanServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext app = getServletContext();
		
		
		request.setAttribute("message1", "request메시지");
		
		String myname = request.getParameter("myname");
		session.setAttribute("message2", myname);
		app.setAttribute("message3", "어플리케이션메시지");

		
		request.getRequestDispatcher("jsp/one.jsp").forward(request, response);
		
		// 요청 재지정, 주소창이 변경된다(새로운 요청이 생김)
		response.sendRedirect("two");
	}

}
