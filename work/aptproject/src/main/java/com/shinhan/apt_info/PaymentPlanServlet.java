package com.shinhan.apt_info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicant_info_model.InfoDTO;
import applicant_info_model.InfoService;

/**
 * Servlet implementation class PaymentPlanServlet
 */
@WebServlet("/paymentplan")
public class PaymentPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		InfoService infoService = new InfoService();
		InfoDTO list = infoService.paymentPlan(Integer.parseInt(bno));
		InfoDTO userdata = infoService.userInfo(Integer.parseInt(bno));
		request.setAttribute("paymentplan", list);
		request.setAttribute("userdata", userdata);
		request.getRequestDispatcher("/info/PaymentPlan.jsp").forward(request, response);
	}

}
