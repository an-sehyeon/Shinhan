package com.shinhan.controller.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;

/**
 * Servlet implementation class DeptInsertServlet
 */
//@WebServlet("/dept/deptinsertAjax.do")
public class DeptInsertServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int deptid = convertInt(request.getParameter("department_id"));
		String deptname = request.getParameter("department_name");
		int managerid = convertInt(request.getParameter("manager_id"));
		int locationid = convertInt(request.getParameter("location_id"));

		DeptDTO dept = DeptDTO.builder().department_id(deptid).department_name(deptname).manager_id(managerid)
				.location_id(locationid).build();

		// DB에 insert 서비스를 호출
		DeptService deptService = new DeptService();
		
		int result;
		if("insert".equals(request.getParameter("job"))){
			result = deptService.insertDept(dept);
		}else {
			result = deptService.updateDept(dept);
		}
		
		

		response.getWriter().append(result+"");
	}

	private int convertInt(String parameter) {
		if (parameter == null || parameter == "")
			return 0;
		return Integer.parseInt(parameter);
	}

}
