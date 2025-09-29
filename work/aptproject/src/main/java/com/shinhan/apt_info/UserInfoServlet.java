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
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userinfoinsert")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String role = "user";
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String reg_no = request.getParameter("reg_no");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String account_open_date = request.getParameter("account_open_date");
		String is_married = request.getParameter("is_married");
		int dependent_count = Integer.parseInt(request.getParameter("dependent_count"));
		int non_home_start_date = Integer.parseInt(request.getParameter("non_home_start_date"));
		int housing_area = Integer.parseInt(request.getParameter("housing_area"));
		
		User_infoService userService = new User_infoService();
		int result = userService.insertUser(role, name, id, password, reg_no, phone, address, dependent_count, non_home_start_date, account_open_date, is_married, housing_area);
		
		String message = result > 0 ? "회원가입성공" : "회원가입 실패";
		System.out.println(message);
		response.sendRedirect("loginpage?message=" + URLEncoder.encode(message,"UTF-8"));
		
	}

}
