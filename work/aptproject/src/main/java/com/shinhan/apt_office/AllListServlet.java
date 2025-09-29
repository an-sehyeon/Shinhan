package com.shinhan.apt_office;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_office_model.OfficeService;

/**
 * 접수자들의 모든 데이터 리스트 조회
 */
@WebServlet("/userlist")
public class AllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OfficeService officeService = new OfficeService();
		
		request.setAttribute("userinfolist", officeService.selectAll());
		
		request.getRequestDispatcher("/office/adminpage.jsp")
			.forward(request, response);
	
	}
	
}
