package com.shinhan.day01;

//>java 자바프로그램
//JVM이 main시작
public class 자바프로그램 {

	public static void main(String[] args) {
		System.out.println("main시작");
		함수1();
		함수2();
		System.out.println("main끝");
	}

	private static void 함수2() {
		System.out.println("함수2입니다.");
		
	}

	private static void 함수1() {
		System.out.println("함수1입니다.");
		
	}

}
