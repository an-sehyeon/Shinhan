package com.shinhan.day08;

// 사용자정의 Exception만들기
public class MyException extends Exception{

	String message;
	public MyException(String message) {
		super(message);
	}
	
}
