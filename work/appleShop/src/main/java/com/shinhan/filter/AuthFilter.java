package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 요청 필터
		// 로그인을 하지않은 사용자에게 제공하지않는 서비스
		HttpServletRequest http_req = (HttpServletRequest)request;
		HttpServletResponse http_res = (HttpServletResponse)response;
		
		HttpSession session = http_req.getSession();
		Object obj = session.getAttribute("loginEmp");
		
		// 주소확인해서 로그인창은 Redirect되지않도록 처리(로그인 불필요 page체크)
		String uri = http_req.getRequestURI();
		//String[] arr = {"/login","/deptinsert","/images","/userInfo","/apt",".css",".js"};
		/*String[] arr = {"/*"};
		//System.out.println("요청주소uri : " + uri);
		boolean isCheck = true;
		for(String addr:arr) {
			if(uri.contains(addr)) {
				isCheck = false; break;
			}
		}
		
		
		  if(isCheck && obj == null) {
			  session.setAttribute("info","로그인을 하지않은 사용자에게 제공하지않는 서비스입니다."); 
			  String path = getServletContext().getContextPath(); 
			  http_res.sendRedirect(path + "/auth/login");
			  return; 
		  }*/
		
		chain.doFilter(request, response);
		
		// 응답 필터
		
		
	}

}
