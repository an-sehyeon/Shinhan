package com.shinhan.controller2.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * // 로그인을 하지 않은 사용자에게 제공하지 않는 서비스임 HttpSession session = request.getSession();
		 * Object obj = request.getAttribute("loginEmp"); if(obj == null) {
		 * session.setAttribute("info","로그인을 하지않은 사용자에게 제공하지않는 서비스입니다."); String path =
		 * getServletContext().getContextPath(); response.sendRedirect(path +
		 * "/auth/login"); return; }
		 */
		
		String empid = request.getParameter("empid");
		if(empid!=null && empid!="") {
			EmpService empService = new EmpService();
			empService.empDeleteById(Integer.parseInt(empid));
		}
		response.sendRedirect("emplist.do");
	}
}
