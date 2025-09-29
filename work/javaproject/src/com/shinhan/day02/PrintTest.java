package com.shinhan.day02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
/*
 *  java.base 모듈
 *  --- java.lang 패키지안에 있는 모든 class는 import없이 사용가능하다.
 *  --- 나머지 패키지에 있는 class들은 반드시 import 후 사용해야됨.
 * */



public class PrintTest {

	public static void main(String[] args) throws IOException {

//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}

	private static void f6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력 >>");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력 >>");
		String age = sc.nextLine();
		// 문자를 숫자로 변경
		int realAge = Integer.parseInt(age) - 1;
		
		System.out.printf("이름은 %s이고, 나이는 %d 입니다.\n", name, realAge);
		
		sc.close();
	}

	private static void f5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력 >>");
		String name = sc.next();		// 단어
		String name2 = sc.next();		// 단어
		System.out.println(name + name2);
		
		sc.nextLine();					// enter
		
		System.out.println("주소를 입력 >>");
		String address = sc.nextLine();	// 한줄
		System.out.println(address);
		
		
		sc.close();
	}

	private static void f4() {
		InputStream is = System.in;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요>>>");
		String name = sc.next();
		
		int age;
		while(true) {
			System.out.print("나이를 입력하세요>>>");
			
			if(sc.hasNextInt()) {
			age = sc.nextInt();
			break;				// 입력값이 숫자라면 반복문 탈출
			}else {
				System.out.println("나이는 숫자로 입력하시오>>");
				sc.next();		// 잘못 입력한 입력값 버리기
			}
			
		}
		
		System.out.printf("이름은 %s이고, 나이는 %d 입니다.\n", name, age);
		
		sc.close();
	}

	// 표준입력(키보드) : System.in => InputStream
	private static void f3() throws IOException {
		InputStream is = System.in;
		
		System.out.println("이름을 입력하세요>>>");
		while(true) {
		int data = is.read();		// 1byte만 읽음
		if(data == 13) break;		// enter를 치면 반복문 종료
		System.out.print((char)data);
		}
	}

	// 표준출력(모니터) : System.out ==> PrintStream
	private static void f2() {
		int score = 100;
		String name = "홍길동";
		double score2 = 200.5;
		
		System.out.println("이름은 " + name + ", 점수는 " + score + ", 점수2는 " + score2);
		System.out.printf("이름은 %s이고 점수는 %-5d점이고 점수2는 %-10.2f이다.\n", name, score, score2);
		System.out.println("=============");
		
	}

	private static void f1() {
		// 출력: println(), print(), printf()
		
		// 이름이 같고 모양이 다르다 = (매개변수) -> overloading
		System.out.print(false);
		System.out.print(10);
		System.out.print("문자");
		System.out.print(3.14);
		System.out.println("!!!");
		System.out.print("-------");
		
	}

}
