package com.shinhan.day01;

// class : 자바프로그램
// main 함수 : 프로그램 시작점
// 함수 : 문장들의 묶음
// JVM은 main함수만 실행한다.
// main이 아닌 다른함수 실행은 반드시 호출해야한다.
public class Hello {
	public static void main(String[] args) {
		// 주석 : 프로그램을 설명, 컴파일는 주석 해석하지 않음
		System.out.println("안녕하세요1");
		System.out.println("안녕하세요2");
		System.out.println("안녕하세요3");
		System.out.println("안녕하세요4");
		
		f1();		// 함수 호출 : 수행 후 돌아온다.
		f2();
		System.out.println("--- main END ---");
		
	}

	// 함수정의
	public static void f1() {
		System.out.println("내가 만든 함수f1 시작");
		System.out.println("내가 만든 함수f1 끝");
	}
	
	// 줄맞추기(formatting) : ctrl + shift + f
	public static void f2() {
		System.out.println("내가 만든 함수f2 시작");
		System.out.println("내가 만든 함수f2 끝");
	}
}
