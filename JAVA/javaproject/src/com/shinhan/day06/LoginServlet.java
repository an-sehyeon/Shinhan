package com.shinhan.day06;

//Servlet : 자바작성된 서버프로그램 , SingleTone으로 만들어진다. 
// SingleTone : 객채를 1번만 생성하고 사용시 생성된 객체를 가져다쓴다. 

public class LoginServlet {

	private static LoginServlet login ;
	
	private LoginServlet() {
		
	}
	public static LoginServlet getInstance() {
		if(login == null) login = new LoginServlet();
		return login;
	}
	
}
