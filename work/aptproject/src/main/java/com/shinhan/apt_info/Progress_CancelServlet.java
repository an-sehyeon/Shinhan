package com.shinhan.apt_info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import applicant_info_model.InfoService;

/**
 * Servlet implementation class Progress_CancelServlet
 */
@WebServlet("/cancel")
public class Progress_CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  name = request.getParameter("name");
		String  userbno = request.getParameter("bno");
		String  reg_no = request.getParameter("reg_no");
		int bno = Integer.parseInt(userbno);
		HttpSession session = request.getSession();
		
		session.setAttribute("name", name);
		
		InfoService infoService = new InfoService();
		int info = infoService.deleteInfo(bno, name, reg_no);
		System.out.println(info+"건 삭제");
		if(info == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
	        response.getWriter().write("delete false");
	        return;
		}
	}

}
