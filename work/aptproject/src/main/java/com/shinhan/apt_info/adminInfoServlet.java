package com.shinhan.apt_info;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicant_info_sign_up_model.User_infoService;

/**
 * Servlet implementation class adminInfoServlet
 */
@WebServlet("/admininfoinsert")
public class adminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String role = "admin";
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String reg_no = request.getParameter("reg_no");
		String phone = request.getParameter("phone");
		String adminkey = request.getParameter("adminkey");
		
		String key = "shinhands";
		String keyerror_msg =  adminkey==key ? "관리자키와 일치" : "관리자키가 일치하지 않습니다.";
		
		System.out.println(keyerror_msg);
		response.sendRedirect("loginpage?keyerror_msg=" + URLEncoder.encode(keyerror_msg,"UTF-8"));
		
		User_infoService userService = new User_infoService();
		int result = userService.insertAdmin(role, name, id, password, reg_no, phone);
		
		String message = result > 0 ? "회원가입성공" : "회원가입 실패";
		System.out.println(message);
		response.sendRedirect("loginpage?message=" + URLEncoder.encode(message,"UTF-8"));
		
	}

}
