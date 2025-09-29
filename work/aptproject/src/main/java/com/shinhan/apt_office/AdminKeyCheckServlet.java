package com.shinhan.apt_office;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminKeyCheckServlet
 */
@WebServlet("/adminkeycheck")
public class AdminKeyCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminkey = "shinhands";
		String key = request.getParameter("key");
		int result = -1;
		if(key.equals(adminkey)) {
			result = 0;
		} else {
			result = -1;
		}
		response.getWriter().append(result+"");
	}

}
