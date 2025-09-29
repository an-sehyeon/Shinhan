package com.shinhan.controller.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;

/**
 * Servlet implementation class DeptDetailServlet
 */
//@WebServlet("/dept/deptdetail")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int deptid = convertInt(request.getParameter("deptid"));
		DeptService deptService = new DeptService();
		DeptDTO dept = deptService.selectById(deptid);

		// dept의 데이터를 dept에 저장
		request.setAttribute("dept", dept);

		request.getRequestDispatcher("deptdetail.jsp").forward(request, response);
	}

	private int convertInt(String data) {
		if (data == null || data == "")
			return 0;
		return Integer.parseInt(data);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// Post는 한글있는 경우 반드시 작성
		request.setCharacterEncoding("utf-8");

		String s_job = request.getParameter("job");
		int deptid = convertInt(request.getParameter("department_id"));
		String deptname = request.getParameter("department_name");
		int managerid = convertInt(request.getParameter("manager_id"));
		int locationid = convertInt(request.getParameter("location_id"));

		DeptDTO dept = DeptDTO.builder().department_id(deptid).department_name(deptname).manager_id(managerid)
				.location_id(locationid).build();
		System.out.println(s_job + ":" + dept);

		// DB에 insert 서비스를 호출
		DeptService deptService = new DeptService();
		int result = deptService.insertDept(dept);
		
		// 데이터 저장
		request.setAttribute("resultMessage", result>0?"수정성공":"수정실패");
		
		// deptresult.jsp로 위임
		request.getRequestDispatcher("deptresult.jsp").forward(request, resp);
	}

}
