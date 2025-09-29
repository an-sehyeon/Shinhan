package com.shinhan.apt_info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_office.model.OfficeDTO;
import application_office.model.OfficeService;

/**
 * Servlet implementation class LuckyDetail
 */
@WebServlet("/luckydetail")
public class LuckyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int bno = Integer.parseInt(name);
		OfficeService officeService = new OfficeService();
		OfficeDTO list = officeService.luckyDetail(bno);
		
		
		
		
	}

}
