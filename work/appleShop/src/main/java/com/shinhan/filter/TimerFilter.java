package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TimerFilter
 */
@WebFilter("*.do")
public class TimerFilter extends HttpFilter implements Filter {
       
    public TimerFilter() {
        super();
        //System.out.println("TimerFilter 생성자");
    }

	
	public void destroy() {
		//System.out.println("TimerFilter destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		HttpServletRequest http_req = (HttpServletRequest)request;
		String cpath = http_req.getContextPath();
		String uri = http_req.getRequestURI();
		//System.out.printf("[요청주소] %s %s \n", cpath, uri);
		
		long end = System.currentTimeMillis();
		//System.out.println("작업시간 : " + (end - start) + "ms");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("TimerFilter init");
	}

}
