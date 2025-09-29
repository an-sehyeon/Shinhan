package com.shinhan.controller.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptService;

/**
 * Servlet implementation class DeptDetailServlet
 */
//@WebServlet("/dept/deptdelete")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int s_deptid = convertInt(request.getParameter("deptid"));
		DeptService deptService = new DeptService();
		int result = deptService.deleteDept(s_deptid);

		// 데이터 저장
		request.setAttribute("resultMessage", result > 0 ? "삭제성공" : "삭제실패");
		// deptresult.jsp로 위임
		request.getRequestDispatcher("deptresult.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String[] arr = request.getParameterValues("del");
			//System.out.println(arr);
			DeptService deptService = new DeptService();
			for(String s_deptid:arr) {
				int deptid = convertInt(s_deptid);
				deptService.deleteDept(deptid);
			}
			response.sendRedirect("deptlist");
		
	}

	private int convertInt(String data) {
		if (data == null || data == "")
			return 0;
		return Integer.parseInt(data);
	}

}
