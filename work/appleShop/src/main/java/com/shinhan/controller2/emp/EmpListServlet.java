package com.shinhan.controller2.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptService;
import emp.EmpService;
import job.JobDAO;

/**
 * Servlet implementation class EmpListServlet
 */
//@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  // 로그인을 하지 않은 사용자에게 제공하지 않는 서비스임
		  /*HttpSession session = request.getSession(); 
		  Object obj = session.getAttribute("loginEmp"); 
		  if(obj == null) {
			  session.setAttribute("info","로그인을 하지않은 사용자에게 제공하지않는 서비스입니다."); 
			  String path = getServletContext().getContextPath(); 
			  response.sendRedirect(path + "/auth/login");
			  return; 
		  }*/
		 
		
		
		// 1. 클라이언트가 요청한 업무로직 수행
		EmpService empService = new EmpService();
		// 데이터 저장
		request.setAttribute("emplist", empService.selectAll());
		
		DeptService deptService = new DeptService();
		request.setAttribute("deptlist", deptService.selectAll());
		
		JobDAO jobDAO = new JobDAO();
		request.setAttribute("joblist", jobDAO.getAllJobs());
		
		// 2. JSP(View담당)에게 위임, 응답은 JSP가 한다.
		request.getRequestDispatcher("empAll.jsp")
			.forward(request, response);
	}


}
