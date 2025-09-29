package com.shinhan.apt_main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_office_model.OfficeDTO;
import application_office_model.OfficeService;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/lottoresult.do")
public class LottoResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { int bno =
	 * Integer.parseInt(request.getParameter("bno")); OfficeService officeService =
	 * new OfficeService(); OfficeDTO office = officeService.luckyDetail(bno); if
	 * (office == null) { System.out.println("해당 접수번호의 사용자는 존재하지 않습니다."); return; }
	 * 
	 * 
	 * request.setAttribute("office", office);
	 * 
	 * if(office.getArea_rank() <= 30) {
	 * request.getRequestDispatcher("/lottoresult/winningpage.jsp").forward(request,
	 * response); }else {
	 * request.getRequestDispatcher("/lottoresult/losingpage.jsp").forward(request,
	 * response); }
	 * 
	 * }
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		OfficeService officeService = new OfficeService();
		OfficeDTO office = officeService.luckyDetail(bno);
		if (office == null) {
			response.setContentType("text/plain; charset=UTF-8");
			response.getWriter().write("-1");
		    return;
		}
		
		request.setAttribute("office", office);
		
		if(office.getArea_rank() <= 30) {
			request.getRequestDispatcher("/lottoresult/winningpage.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/lottoresult/losingpage.jsp").forward(request, response);
		}
		
	}
}
