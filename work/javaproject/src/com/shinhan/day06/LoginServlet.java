package com.shinhan.day06;

// Servlet : 자바로 작성된 서버프로그램, SingleTone으로 만들어진다.
// SingleTone : 객체를 1번만 생성하고 사용시 생성된 객체를 가져다 쓴다.

public class LoginServlet {
	
	private static LoginServlet login = new LoginServlet();
	
	private LoginServlet() {
		
	}
	
	public static LoginServlet getInstatnce() {
		if(login == null) login = new LoginServlet();
		return login;
	}
}
