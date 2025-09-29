package com.shinhan.controller2.emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/selectByDept.do")
public class EmpListServletDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		
		
		EmpService empService = new EmpService();
		request.setAttribute("emplist", empService.selectByDept(deptid));
		
		RequestDispatcher rd = request.getRequestDispatcher("empByCondition.jsp");
		rd.forward(request, response);
	}


}
