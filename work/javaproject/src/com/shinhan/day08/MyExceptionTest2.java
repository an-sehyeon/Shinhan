package com.shinhan.day08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 프로그램은 오류가 발생하면 중단된다.
// Exception : 프로그래머의 노력으로 복구 가능한 오류(프로그램이 중단되지않고 계속 진행)
// 1) RuntimeException : 실행시 오류 Check, 컴파일시 체크안함. UnChecked Exception
// - JVM이 자동으로 던진다.
//		- NullPointer, ArrayIndexOutOfBoundsException, ArithmeticException...

// 2) 일반 EXception : RuntimeException이 아닌 Exception, 반드시 컴파일시 Checked Exception
// 		- Exception 발생시 해결방법
//	1) 내 함수를 부른곳으로 떠넘긴다.(던진다) : 함수의 선언부에 throws Exception Class이름
//  2) 내가 해결한다 (try~catch~finally)
public class MyExceptionTest2 {

	public static void main(String[] args) {
//		f5();
//		f6();
		f7();
	}
	
	
	private static void f7() {
		
		// JVM이 자동으로 예외처리를 할 수 없다.
		// 비즈니스 로직에 의해 강제로 예외를 일으키고자 한다.
		int score = -20;
		
		try {
			if(score < 0 || score > 100) {
				throw new MyException("0<=score<=100만 가능");
			}
		}catch(MyException e ){
			System.out.println(e.getMessage());
		}
		System.out.println("-----f7 end-----");
		
	}


	// Checked Exception : 1)떠넘긴다. 2)처리한다.
	private static void f6() {
		
		try {
			Class aa = Class.forName("java.lang.String");
			System.out.println(aa.getName());
			System.out.println(aa.getSimpleName());
			System.out.println(aa.getModule());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void f5() {
		try (FileReader fr = new FileReader("src/com/shinhan/day08/AnonymousExample.java")) {
			int data;

			while ((data = fr.read()) != -1) {
				System.out.println((char) data);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 본래는 자원반납이 이루어지는 위치
			// try(!!!){}catch(){}finally{}
			// try를 벗어나면 자동으로 자원이 반납됨.
		}

	}

	public static void f4(String[] args) {
//		f1(2);
//		f2();
		try {
			f3();
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로와 이름 확인이 필요하다.");
		} catch (IOException e) {
			System.out.println("IO error");
		}
		System.out.println("===Main END===");
	}

	private static void f3() throws IOException {

		// 파일을 읽을 수 있는 코드, 2byte씩 읽을 수 있음.
		FileReader fr = new FileReader("src/com/shinhan/day08/InnerClassTest.java");
		System.out.println("파일이 존재하므로 읽을 수 있다.");

		int data;

		while ((data = fr.read()) != -1) { // EOF(End Of File)
			System.out.print((char) data);
		}
		fr.close(); // 자원반납
	}

	private static void f2() {
		String str = null;

		try {
			System.out.println(str.length());
		} catch (RuntimeException e) {
			// 자동형변환된다.
			// NullPointerException e = new NullPointerException()
			System.out.println(e.getMessage());
		} finally {
			System.out.println("반드시 수행!!!!!!");
		}
		System.out.println("--f2 end---");
	}

	private static void f1(int j) {
		int[] arr = null;
		arr = new int[5];
		String score = "100점";

		try {
			int i_score = Integer.parseInt(score);
			System.out.println(i_score);
			System.out.println("배열접근 : " + arr[0]);
			System.out.println("배열접근 : " + arr[5]);
			int i = 10 / j;

			System.out.println(i);

		} catch (ArithmeticException e) {
			// Exception이 발생하면 자동으로 JVM이 Exception 객체를 만든다.
			// ex) new ArithmeticException()
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("null은 접근불가");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("index 범위 벗어남");
//		}catch (NumberFormatException e) {
//			System.out.println("숫자형 문자만 int로 변경가능하다.");
		} catch (Exception e) {
			// 형변환이 자동으로 이루어지므로 맨상위의 class를 마지막에 작성한다.
			System.out.println("기타 Exception : " + e.getMessage());
		} finally {
			System.out.println("Exception발생여부와 무관하게 반드시 수행한다.");
		}
		System.out.println("---f1 END---");
	}

}
