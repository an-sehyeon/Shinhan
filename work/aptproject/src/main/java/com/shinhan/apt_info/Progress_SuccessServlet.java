package com.shinhan.apt_info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Progress_SuccessServlet
 */
@WebServlet("/success")
public class Progress_SuccessServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		String name = request.getParameter("name");
		String reg_no = request.getParameter("reg_no");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String housing_area = request.getParameter("housing_area");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("bno", bno);
		session.setAttribute("name", name);
		session.setAttribute("reg_no", reg_no);
		session.setAttribute("phone", phone);
		session.setAttribute("address", address);
		session.setAttribute("housing_area", housing_area);
		
	}

}
