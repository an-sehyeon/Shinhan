package com.shinhan.apt_office;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicant_info_model.InfoService;

/**
 * Servlet implementation class UserInfoDeleteServlet
 */
@WebServlet("/userdelete.do")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userbno = request.getParameter("bno");
		String name = request.getParameter("name");
		String reg_no = request.getParameter("reg_no");
		int bno = Integer.parseInt(userbno);
		
		System.out.println(bno+name+reg_no);
		InfoService infoService = new InfoService();
		int result = infoService.deleteInfo(bno, name, reg_no);
		System.out.println(bno+"번 접수자정보" + result+"건 삭제");
		if(result == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
	        response.getWriter().write("delete false");
	        return;
		}
		String message = result > 0 ? "해당접수자삭제성공" : "삭제실패";
		System.out.println(message);
		response.sendRedirect("userlist?message=" + URLEncoder.encode(message,"utf-8"));
		
		
		
	}

}
