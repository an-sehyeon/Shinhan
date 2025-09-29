package com.shinhan.apt_main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicant_info_sign_up_model.User_infoDTO;
import applicant_info_sign_up_model.User_infoService;

/**
 * Servlet implementation class AptMainServlet
 */
@WebServlet("/loginpage")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User_infoService userService = new User_infoService();
		List<User_infoDTO> addressList = userService.address_select();
		List<User_infoDTO> dependentList = userService.dependent_select();
		List<User_infoDTO> nonhomeList = userService.nonhome_select();
		List<User_infoDTO> accountList = userService.account_select();
		List<User_infoDTO> areaList = userService.area_select();
		
	
		request.setAttribute("addresslist", addressList);
		request.setAttribute("dependentList", dependentList);
		request.setAttribute("nonhomeList", nonhomeList);
		request.setAttribute("accountList", accountList);
		request.setAttribute("areaList", areaList);
		
		
		
		request.getRequestDispatcher("auth/login.jsp").forward(request, response);
		
	}

}
