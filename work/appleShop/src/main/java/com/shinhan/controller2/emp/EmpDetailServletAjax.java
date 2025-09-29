package com.shinhan.controller2.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpDTO;
import emp.EmpService;

/**
 * Servlet implementation class EmpDetailList
 */
//@WebServlet("/emp/getEmpById.do")
public class EmpDetailServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  
		
		int emp_id = Integer.parseInt(request.getParameter("empid"));
		EmpService eService = new EmpService();
		EmpDTO emp = eService.selectById(emp_id);
		
		int result = -1;
		if(emp == null) {
			result = 0;
		}
		System.out.println("result : " + result);
		response.getWriter().append(result+"");

	}
	

}
