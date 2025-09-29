package com.shinhan.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.EmpDTO;
import emp.EmpService;

/**
 * 405 - 허용되지 않는 메소드, 요청한 메서드가 정의되지 않음
 * 404 - 요청한 주소의 Mapping이 없음
 * 서버시작오류? 서버시작시 web.xml실행 @WebServlet
 * 서블릿 default 경로는 contextPath :  / appleShop
 */
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* URL pattern연습 */
		String spath = request.getContextPath();
		String url = request.getRequestURL().toString();		// StringBuffer -> String
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String address = request.getRemoteAddr();
		
		/*
		 * System.out.println("getContextPath : "+spath); // /appleShop
		 * System.out.println("getRequestURL : "+url); //
		 * http://192.168.0.200:9090/appleShop/auth/login
		 * System.out.println("getServletPath : "+mapping); // /auth/login
		 * System.out.println("getRequestURI : "+uri); // /appleShop/auth/login
		 * System.out.println("getMethod : "+method); // GET
		 * System.out.println("getRemoteAddr : "+address);	// 서버의 접속한 client의 ip
		 */		
		
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
       
	// get요청으로 한글이 넘어오면 자동으로 encoding, decoding된다 (깨짐없음)
	// post는 한글이 넘어오면 요청문서의 body로 encoding없이 넘어온다.(깨짐)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String u_id = request.getParameter("userid");
		String u_pwd = request.getParameter("pswd"); 
		String u_remember = request.getParameter("remember"); 
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//로그인 체크 ....employees table => userid는 employee_id, pswd는 email
		if(u_id=="" && u_pwd=="" ) {
			System.out.println("아이디와 비밀번호 입력 오류");
			response.sendRedirect("login");
			return;
		}
		
		int empid = Integer.parseInt(u_id);
		EmpService empService = new EmpService();
		EmpDTO emp = empService.selectById(empid);
		if(emp == null) {
			System.out.println("아이디 오류");
			response.sendRedirect("login");
			return;
		}
		
		if(!(emp.getEmail().equals(u_pwd))){
			System.out.println("비밀번호 오류");
			response.sendRedirect("login");
			/*
			 * out.print("<script>alert('비밀번호가 일치하지 않습니다.'); location.href='" +
			 * request.getContextPath() + "/auth/login';</script>"); ou
			 t.flush();*/
			return;
		}
		
		
		System.out.println("로그인성공");
		HttpSession session = request.getSession(); //true : 세션이 존재하면 얻고 없으면 생성
		session.setMaxInactiveInterval(24*60*60);
		session.setAttribute("loginEmp", emp);
		session.setAttribute("info", "");
		
		// 직원조회로 가기			// http://localhost:9090/ 생략 : default
		String cpath = getServletContext().getContextPath();	// appleShop
		response.sendRedirect(cpath + "/emp/emplist.do");
		
		
		
		
		
		
		/*String[] arr = request.getParameterValues("subject");
		
		
		System.out.println("u_id : " + u_id);
		System.out.println("u_pwd : " + u_pwd);
		System.out.println("u_remember : " + u_remember);
		System.out.println("subject배열 = " + Arrays.toString(arr));
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String param = names.nextElement();
			if(param.equals("subject")) {
				String[] data = request.getParameterValues("subject");
				System.out.println("data= " + Arrays.toString(data));
			}else {
				String data = request.getParameter(param);
				System.out.println("data=> " + data);
			}
			
		}
		
		// MVC2모델은 Servlet과 JSP가 함께 각자 담당 구현
		// servlet = JAVA + HTML
		// JSP = JAVA + HTML
		
		// 응답문서를 설정하고 만들기
		// 주의 : 설정 후 문서만들기가 되어야한다.
		
    	
    	out.print("<h1>응답문서</h1>");
    	out.print("<h1>path:" + request.getContextPath() + "</h1>");
    	out.print("<h1>접속한 client: " + request.getRemoteAddr() + "</h1>");
		out.print("<h1>로그인한 사용자 : "+ emp +"</h1>");*/
	}


}
