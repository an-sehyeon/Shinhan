package com.shinhan.controller.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;

/**
 * http://localhost:9090/appleShop
 */
//@WebServlet("/dept/deptlist")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeptService deptService = new DeptService();
		List<DeptDTO>deptlist = deptService.selectAll();
		
		// 요청객체에 조회된 내용을 저장한다.
		request.setAttribute("deptListData", deptlist);
		request.setAttribute("myName", "An");
		
		// 결과를 JSP에 위임
		request.getRequestDispatcher("deptlist.jsp")
			.forward(request, response);
		
		// Servlet : 자바담당, HTML tag사용하는 것은 바람직하지 않다.
		// JSP : HTML 담당, JAVA코드를 사용하지 않는 것이 바람직하다.
		// 해결 -> 응답은 서블릿이 받고 자바코드수행하고 결과는 JSP에 위임하여 응답한다.
		
		 /* response.setContentType("text/html;charset=utf-8");
		 * response.getWriter().append("Served at: ").append(request.getContextPath())
		 * .append(deptlist.size() + "건") .append(deptlist.toString())
		 * .append(request.getContextPath());
		 */
	}


}
