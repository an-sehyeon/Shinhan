package com.shinhan.controller.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/deptinsert")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 입력창보이기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 결과를 JSP에 위임
		request.getRequestDispatcher("deptinsert.jsp").forward(request, response);
	}

	// DB에 insert
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Post는 한글있는 경우 반드시 작성
		//request.setCharacterEncoding("utf-8");

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
		request.setAttribute("resultMessage", result > 0 ? "입력성공" : "입력실패");

		// deptresult.jsp로 위임
		request.getRequestDispatcher("deptresult.jsp").forward(request, response);

		/*
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
		 * response.getWriter(); out.print("<h1> "+ (result>0?"입력성공":"입력실패") + "</h1>");
		 * out.print("<a href='deptlist'>목록보기</a>");
		 */
	}

	private int convertInt(String parameter) {
		if (parameter == null || parameter == "")
			return 0;
		return Integer.parseInt(parameter);
	}

}
