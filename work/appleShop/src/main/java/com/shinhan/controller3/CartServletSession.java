package com.shinhan.controller3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/addcart2.do")
public class CartServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/addCart2.jsp").forward(request, response);
		
	}
	
	// 세션을 이용해서 장바구니 담
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		int count = Integer.parseInt(request.getParameter("count"));	// 신규개수
		
		// 세션에 저장된 cart를 읽어온다
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<String, Integer> cart = null;
		if(obj == null) {
			cart = new HashMap<String, Integer>();	// 없으면 cart를 생성
			cart.put(product, count);
			session.setAttribute("cart", cart);
		}else {
			cart = (Map<String, Integer>)obj;		// 있으면 형변환
			if(cart.containsKey(product)) {
				cart.put(product, cart.get(product) + count);
			}else {
				cart.put(product, count);
			}
		}
		
		// 있으면 같은 상품이 있는지 확인 후 같은 상품이면 갯수 수정
		
		
		response.sendRedirect("addcart2.do");
	}

}
