package com.shinhan.controller3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpDTO;


/**
 * Servlet implementation class SetServlet
 */
//@WebServlet("/get")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * public GetServlet() { System.out.println("GetServlet생성자"); }
	 * 
	 * 
	 * @Override public void init(ServletConfig config) throws ServletException {
	 * System.out.println("GetServlet init"); }
	 */




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletContext : application당 하나, 서버종료시 소멸됨.
		
		ServletContext app = getServletContext();
		String name = (String)app.getAttribute("connectName");	// String
		List<EmpDTO> emplist = (List<EmpDTO>)app.getAttribute("emplist");		// List
		EmpDTO emp = (EmpDTO)app.getAttribute("emp");			// EmpDTO
		
		// web.xml의 context-param를 읽기
		String dbname = app.getInitParameter("DBName");
		String id = app.getInitParameter("userId");
		String pass = app.getInitParameter("userPass");
		
		// web.xml의 servlet의 init-param읽기
		String lunch = getInitParameter("lunch");
		
		
		// 현재 프로그램이 실행되고 있는 실제위치?
		String path = app.getRealPath("."); 
		
		
		
		// "" + null => null
		response.setContentType("text/html;charset=utf-8");
		response.getWriter()
			.append("<h1>ServletContext에 getting함</h1>")
			.append("<h1>name: " + name + "</h1>")
			.append("<h1>emplist건수: " + emplist.size() + "</h1>")
			.append("<h1>emp정보: " + emp.toString() + "</h1>")
			.append("<h2>dbname: " + dbname + "</h1>")
			.append("<h2>id정보: " + id + "</h1>")
			.append("<h2>pass정보: " + pass + "</h1>")
			.append("<h2>점심메뉴 : " + lunch + "</h2>")
			.append("<h2>실제path : " + path + "</h2>");	
		
		
	}

}
