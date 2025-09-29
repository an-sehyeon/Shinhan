package com.shinhan.day08.exception;

import java.io.IOException;

public class MyExceptionTest {

	public static void main(String[] args) throws IOException {
//		f1(2);
//		f2();
//		f3();
		f4();
		System.out.println("====Main END =====");
	}

	private static void f4() throws IOException {
		// 일반예외는 Exception 해결할 의무가 있따. 해결안하면 컴파일 오류이다.
		// 1) 해별방법 1 : 떠넘긴다. (나의 함수를 부른곳으로 떠넘김)
		// 2) 해결방법 2 : 내가 처리한다. 
		int i = System.in.read();
		System.out.println(i);
		
	}

	private static void f3() {
		String score = "100점";
		
		try {
		int intScore = Integer.parseInt(score);
		System.out.println(intScore + 10);
		}catch(NumberFormatException e){
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("===f3 END===");
	}

	private static void f2() {
		
		int[] arr = null;
		
		try {
		System.out.println(arr[5]);
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		System.out.println("===f2 END===");
	}

	// Exception(예외) : 예외가 발생하면 프로그램 중단, 예외 처리하면 계속 진행하도록 할수있다.
	// 1) RuntimeException => 컴파일시에 오류처리 안함. 실행시 처리 ArithmeticException
	// 2) 일반예외
	private static void f1(int b) {
		try {
			// 예외발생가능성이 있는 문장
		int a = 10/b;
		System.out.println(a);
	}catch(ArithmeticException e) {
		// 예외를 처리함
		System.out.println(e.getMessage());
	}
		System.out.println("====END====");
	}
}
